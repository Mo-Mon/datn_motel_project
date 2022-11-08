package com.example.datn_motel_project.service;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
public interface ImageService {
    public String storeFile(MultipartFile file);
    public Stream<Path> loadAll(); //load all file inside a folder
    public byte[] readFileContent(String fileName);
    public void deleteAllFiles();
    public List<String> storeListFile(List<MultipartFile> files);
}
