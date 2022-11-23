package com.example.datn_motel_project.service;

import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
public interface ImageService {
    public Image storeFile(MultipartFile file, Account account);
    public Stream<Path> loadAll(); //load all file inside a folder
    public byte[] readFileContent(String fileName);
    public void deleteAllFiles();
    public List<Image> storeListFile(List<MultipartFile> files, Account account);
}
