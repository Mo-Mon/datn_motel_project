package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.entity.Image;
import com.example.datn_motel_project.service.AccountService;
import com.example.datn_motel_project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/imagePublic/{name}")
    public void getData(HttpServletRequest request, HttpServletResponse response, @PathVariable("name") String name){
        try {
            response.getOutputStream().write(imageService.readFileContent(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/imagePublic/upload")
    @ResponseBody
    public ResponseEntity<?> uploadImage(Model model, @RequestParam("image") MultipartFile file, HttpSession session) {
        Image image = imageService.storeFile(file,accountService.findById( (Long) session.getAttribute("accountId")).get());
        return ResponseEntity.status(HttpStatus.OK).body(image);
    }
}
