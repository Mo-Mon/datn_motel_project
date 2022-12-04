package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.entity.Image;
import com.example.datn_motel_project.repository.AccountRepository;
import com.example.datn_motel_project.repository.ImageRepository;
import com.example.datn_motel_project.service.AccountService;
import com.example.datn_motel_project.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
public class DummyController {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageService imageService;

    @Autowired
    private AccountRepository accountRepository;
    @GetMapping("/dummy")
    public String getListImage(Model model) {
        List<Image> list = imageRepository.findAll();
        model.addAttribute("lists", list);
        return "index";
    }

    @PostMapping("/dummy/upload")
    public String uploadImage(Model model, @RequestParam("image") MultipartFile file, HttpSession session) {
        Image image = imageService.storeFile(file,accountRepository.findById( (Long) session.getAttribute("accountId")).get());
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

    @GetMapping("/test")
    public String test(){
        return "addmotel";
    }
    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public String handleFileUpload(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> iterator = request.getFileNames();

        while (iterator.hasNext()) {
            String fileName = iterator.next();
            MultipartFile multipartFile = request.getFile(fileName);
            byte[] file = multipartFile.getBytes();

            // do stuff...

        }

        // do stuff...
        return "success";
    }
}
