package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.dto.FileSessionDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.entity.*;
import com.example.datn_motel_project.form.AddMotelForm;
import com.example.datn_motel_project.form.MotelDetailInfoForm;
import com.example.datn_motel_project.service.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class AddMotelController {

    @Autowired
    private AmenitiesService amenitiesService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private MotelTypeService motelTypeService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private ProjectMotelService projectMotelService;

    @Autowired
    private TimePayService timePayService;

    @GetMapping("/seller/addMotel")
    public String addMotel(Model model, HttpSession session){
        String key = UUID.randomUUID().toString().replace("-", "");
        key = "addMotel"+key;
        AddMotelForm motelForm = new AddMotelForm("Thêm Mới Nhà Trọ",key);
        model.addAttribute("motelForm", motelForm);
        setupView(model,session);
        return "addmotel";
    }

    @PostMapping ("/seller/addMotel/confirm")
    public String test(@ModelAttribute("motelForm") AddMotelForm motelForm,@RequestParam("listImage") List<MultipartFile> listImage,
    Model model, HttpSession session, RedirectAttributes redirectAttributes
    ) throws IOException {
        session.setAttribute("motelForm",motelForm);
        model.addAttribute("listImage",listImage);
        List<Object> list = new ArrayList<>();
        list.add(motelForm);
        list.add(listImage.size());
        List<String> listImageSessionName = saveImageInSession(listImage,session);
        String key = motelForm.getKey();
        session.setAttribute("listImage"+key,listImageSessionName);
        redirectAttributes.addFlashAttribute("key",key);
        return "redirect:/seller/motelDetailInfoPreview";
    }

    @GetMapping("/seller/motelDetailInfoPreview")
    public String hello(Model model,HttpSession session){
        String key = (String) model.getAttribute("key");
        model.addAttribute("key",key);
        List<String> listImageSessionName = (List<String>) session.getAttribute("listImage"+key);
        AddMotelForm motelForm = (AddMotelForm) session.getAttribute("motelForm");
        model.addAttribute("listImage",listImageSessionName);
        MotelInfoDto motelInfoDto = convertAddMotelFormToMotelInfo(motelForm);
        MotelDetailInfoForm motelDetailInfoForm = new MotelDetailInfoForm();
//        model.addAttribute("accountInfoDto",motelService.getAccountPortMotel(Long.parseLong(id)));
        model.addAttribute("motelInfoDto",motelInfoDto);
        return "moteldetailinfor";
    }

    private MotelInfoDto convertAddMotelFormToMotelInfo(AddMotelForm motelForm) {
        MotelInfoDto motelInfoDto = new MotelInfoDto();
        motelInfoDto.setTitle(motelForm.getTitle());
        motelInfoDto.setShortContent(motelForm.getShortContent());
        motelInfoDto.setContent(motelForm.getContent());
        motelInfoDto.setMaxPeople(motelForm.getMaxPeople());
        motelInfoDto.setCountBedroom(motelForm.getCountBedroom());
        motelInfoDto.setCountWC(motelForm.getCountWC());
        motelInfoDto.setArea(motelForm.getArea());
        motelInfoDto.setCount(motelForm.getCount());
        motelInfoDto.setCountHired(0);
        motelInfoDto.setStatus("0");
        for(Long id: motelForm.getLimitGendersId()){
            Gender gender = genderService.findById(id);
            motelInfoDto.getLimitGenders().add(gender.getName());
        }
        for(Long id: motelForm.getListMotelTypeId()){
            MotelType motelType = motelTypeService.findMotelTypeById(id);
            motelInfoDto.getListMotelType().add(motelType.getName());
        }
        Set<Amenities> listAmenities = new LinkedHashSet<>();
        for(Long id: motelForm.getListAmenitiesIn()){
            listAmenities.add(amenitiesService.findById(id));
        }
        for(Long id: motelForm.getListAmenitiesOut()){
            listAmenities.add(amenitiesService.findById(id));
        }
        motelInfoDto.setListAmenities(listAmenities);
        // id
        motelForm.getLocationId();
        motelInfoDto.setLocationName("");
        motelInfoDto.setPrice(motelForm.getPrice());
        motelForm.getTypePayId();
        motelInfoDto.setTypePay("");
        motelForm.getTypePayId();
        motelInfoDto.setProjectType("");
        motelInfoDto.setNameUserPort("");

        return motelInfoDto;
    }

    private void setupView(Model model, HttpSession session){
        Long accountId = (Long) session.getAttribute("accountId");
        List<Amenities> listAmenitiesIn = amenitiesService.findAmenities("0",accountId);
        model.addAttribute("listAmenitiesIn",listAmenitiesIn);
        List<Amenities> listAmenitiesOut = amenitiesService.findAmenities("1",accountId);
        model.addAttribute("listAmenitiesOut",listAmenitiesOut);
        List<Gender> listGender = genderService.findAll();
        model.addAttribute("listGender",listGender);
        List<MotelType> motelTypes = motelTypeService.findAllMotelType();
        model.addAttribute("listMotelType", motelTypes);
        List<Location> listLocation = locationService.findAllLocation();
        model.addAttribute("listLocation",listLocation);
        List<ProjectMotel> listProjectMotel = projectMotelService.findAllProjectMotel();
        model.addAttribute("listProjectMotel",listProjectMotel);
        List<TimePay> listTimePay = timePayService.findAllTimePay();
        model.addAttribute("listTimePay",listTimePay);
    }

    private List<String> saveImageInSession(List<MultipartFile> listImage,HttpSession session) throws IOException {
        List<String> listFileName = new ArrayList<>();
        for(MultipartFile image: listImage){
            FileSessionDto fileSessionDto = new FileSessionDto();
            fileSessionDto.setFileName(image.getOriginalFilename());
            fileSessionDto.setSize(image.getSize());
            fileSessionDto.setData(image.getBytes());
            String fileExtension = FilenameUtils.getExtension(image.getOriginalFilename());
            String generatedFileName = UUID.randomUUID().toString().replace("-", "");
            generatedFileName = generatedFileName+"."+fileExtension;
            session.setAttribute(generatedFileName,fileSessionDto);
            listFileName.add(generatedFileName);
        }
        return listFileName;
    }
}
