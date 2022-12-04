package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Image;
import com.example.datn_motel_project.repository.ImageRepository;
import com.example.datn_motel_project.service.ImageService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    private final Path storageFolder = Paths.get("DataImagePublic");
    public ImageServiceImpl() {
        try {
            Files.createDirectories(storageFolder);
        }catch (IOException exception) {
            throw new RuntimeException("bị lỗi, không thể tạo file", exception);
        }
    }
    public boolean isImageFile(MultipartFile file) {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList(new String[] {"png","jpg","jpeg", "bmp"})
                .contains(fileExtension.trim().toLowerCase());
    }
    @Override
    public Image storeFile(MultipartFile file, Account account) {
        try {
            System.out.println("bắt đầu lấy ảnh");
            if (file.isEmpty()) {
                throw new RuntimeException("file gửi lên bị trống");
            }
            if(!isImageFile(file)) {
                throw new RuntimeException("file không phải là ảnh");
            }
            float fileSizeInMegabytes = file.getSize() / 1_000_000.0f;
            if(fileSizeInMegabytes > 5.0f) {
                throw new RuntimeException("File phải có dung lượng <= 5Mb");
            }
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            String generatedFileName = UUID.randomUUID().toString().replace("-", "");
            generatedFileName = generatedFileName+"."+fileExtension;
            Path destinationFilePath = this.storageFolder.resolve(
                    Paths.get(generatedFileName))
                    .normalize().toAbsolutePath();
            if (!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())) {
                throw new RuntimeException(
                        "không thể lưu trử ngoài thư mục hiện tại");
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
            Image image = new Image();
            image.setPath(generatedFileName);
            return imageRepository.save(image);
        }
        catch (IOException exception) {
            throw new RuntimeException("đã có lỗi xảy ra khi lưu file", exception);
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.storageFolder, 1)
                    .filter(path -> !path.equals(this.storageFolder) && !path.toString().contains("._"))
                    .map(this.storageFolder::relativize);
        }
        catch (IOException e) {
            throw new RuntimeException("lỗi load file ảnh", e);
        }

    }

    @Override
    public byte[] readFileContent(String fileName) {
        try {
            Path file = storageFolder.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
                return bytes;
            }
            else {
                throw new RuntimeException(
                        "không load được file: " + fileName);
            }
        }
        catch (IOException exception) {
            throw new RuntimeException("không load được file: " + fileName, exception);
        }
    }

    @Override
    public void deleteAllFiles() {

    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public List<Image> storeListFile(List<MultipartFile> files, Account account) {
        List<Image> listFileName = new ArrayList<>();
        for(MultipartFile file: files){
            listFileName.add(storeFile(file,account));
        }
        return listFileName;
    }
}
