package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.entity.Image;
import com.example.datn_motel_project.repository.ImageRepository;
import com.example.datn_motel_project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class DummyController {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageService imageService;

    @GetMapping("/dummy")
    public String getListImage(Model model) {
        List<Image> list = imageRepository.findAll();
        model.addAttribute("lists", list);
        return "index";
    }

    @PostMapping("/dummy/upload")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file) {
        String name = imageService.storeFile(file);
        model.addAttribute("msg", "Uploaded images: " + name);
        return "redirect:/";
    }

    @GetMapping("/dummy/{name}")
    public void getData(HttpServletRequest request, HttpServletResponse response, @PathVariable("name") String name){
        try {
            response.getOutputStream().write(imageService.readFileContent(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
