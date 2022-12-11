package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.common.BaseLogic;
import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.FileSessionDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.dto.MotelSubDto;
import com.example.datn_motel_project.entity.*;
import com.example.datn_motel_project.form.AddMotelForm;
import com.example.datn_motel_project.form.MotelDetailInfoForm;
import com.example.datn_motel_project.service.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
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

    @Autowired
    private ImageService imageService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private MotelService motelService;


    @GetMapping("/seller/addMotel")
    public String addMotel(Model model, HttpSession session){
        String key = UUID.randomUUID().toString().replace("-", "");
        key = "addMotel"+key;
        AddMotelForm motelForm = new AddMotelForm("Thêm Mới Nhà Trọ",key);
        model.addAttribute("motelForm", motelForm);
        setupView(model,session);
        return "addmotel";
    }

    @GetMapping(value = "/seller/addMotel",params = {"action=back"})
    public String back(Model model, HttpSession session,@RequestParam(name = "key") String key){
        List<String> listImageSessionName = (List<String>) session.getAttribute("listImage"+key);
        AddMotelForm motelForm = (AddMotelForm) session.getAttribute("motelForm"+key);
        model.addAttribute("motelForm", motelForm);
        model.addAttribute("listImage",listImageSessionName);
        setupView(model,session);
        return "addmotel";
    }

    @GetMapping("/seller/editMotel/{id}")
    public String editMotel(@PathVariable("id") String id, Model model, HttpSession session){
        String key = UUID.randomUUID().toString().replace("-", "");
        Motel motel = motelService.findMotelById(Long.parseLong(id));
        AddMotelForm motelForm = convertMotelToAddMotelForm(motel);
        key = "addMotel"+key;
//        AddMotelForm motelForm = new AddMotelForm("Chỉnh sửa Nhà Trọ",key);
        motelForm.setTitleMode("Chỉnh sửa phòng trọ");
        motelForm.setKey(key);
        motelForm.setId(id);
        model.addAttribute("motelForm", motelForm);
        setupView(model,session);
        return "addmotel";
    }


    @PostMapping ("/seller/addMotel/confirm")
    public String confirm(@ModelAttribute("motelForm") AddMotelForm motelForm,@RequestParam("listImage") Optional<List<MultipartFile>> listImage,
    Model model, HttpSession session, RedirectAttributes redirectAttributes
    ) throws IOException {
        model.addAttribute("listImage",listImage);
        List<Object> list = new ArrayList<>();
        list.add(motelForm);
        List<String> listImageSessionName = new ArrayList<>();
        if(listImage.isPresent()){
            list.add(listImage.get().size());
            listImageSessionName = saveImageInSession(listImage.get(),session);
        }
        String key = motelForm.getKey();
        session.setAttribute("motelForm"+key,motelForm);
        session.setAttribute("listImage"+key,listImageSessionName);
        redirectAttributes.addFlashAttribute("key",key);
        return "redirect:/seller/motelDetailInfoPreview";
    }

    @GetMapping("/seller/motelDetailInfoPreview")
    public String previewMotel(Model model,HttpSession session){
        String key = (String) model.getAttribute("key");
        model.addAttribute("key",key);
        List<String> listImageSessionName = (List<String>) session.getAttribute("listImage"+key);
        AddMotelForm motelForm = (AddMotelForm) session.getAttribute("motelForm"+key);
        model.addAttribute("listImage",listImageSessionName);
        MotelInfoDto motelInfoDto = convertAddMotelFormToMotelInfo(motelForm);
        MotelDetailInfoForm motelDetailInfoForm = new MotelDetailInfoForm();
        motelDetailInfoForm.setMode("preview");
        motelDetailInfoForm.setKey(key);
        List<Image> listImageDb = new ArrayList<>();
        if(!BaseLogic.checkEmptyString(motelForm.getId())){
            listImageDb = motelService.findImageByMotelId(Long.parseLong(motelForm.getId()));
        }
        List<Image> listImageOld = new ArrayList<>();
        for(Image image: listImageDb){
            if(!motelForm.getListIdImageDelete().contains(image.getId())){
                listImageOld.add(image);
            }
        }
        motelDetailInfoForm.setListImageOld(listImageOld);
        Long accountId = (Long) session.getAttribute("accountId");
        AccountInfoDto accountInfoDto = accountService.getAccountInfo(accountId);
        motelDetailInfoForm.setAccountInfoDto(accountInfoDto);
        motelDetailInfoForm.setMotelInfoDto(motelInfoDto);
        model.addAttribute("motelDetailInfoForm",motelDetailInfoForm);
        return "moteldetailinfor";
    }

    @PostMapping("/seller/motelSave")
    public String save(Model model,HttpSession session,@RequestParam(name = "key") String key){
        Long accountId = (Long) session.getAttribute("accountId");
        Account account = accountService.findById(accountId).get();
        AddMotelForm motelForm = (AddMotelForm) session.getAttribute("motelForm"+key);
        List<String> listImageSessionName = (List<String>) session.getAttribute("listImage"+key);
        List<FileSessionDto> listImageSession = new ArrayList<>();
        for(String file: listImageSessionName){
            FileSessionDto fileSessionDto = (FileSessionDto) session.getAttribute(file);
            listImageSession.add(fileSessionDto);
        }
        motelService.saveMotel(motelForm,account,listImageSession);
        return "redirect:/seller/managerMotel";
    }

    @PostMapping("/seller/motelCancel")
    public String cancelMotel(HttpSession session,WebRequest request, SessionStatus status, @RequestParam(name = "key") String key){
        AddMotelForm motelForm = (AddMotelForm) session.getAttribute("motelForm"+key);
        String url = "/seller/addMotel";
        if(!BaseLogic.checkEmptyString(motelForm.getId())){
            url = "/seller/editMotel/" + motelForm.getId();
        }
        status.setComplete();
        request.removeAttribute("motelForm"+key, WebRequest.SCOPE_SESSION);
        List<String> listImageSessionName = (List<String>) session.getAttribute("listImage"+key);
        for(String image: listImageSessionName){
            request.removeAttribute(image,WebRequest.SCOPE_SESSION);
        }
        request.removeAttribute("listImage"+key,WebRequest.SCOPE_SESSION);

        return "redirect:" + url;
    }

    private AddMotelForm convertMotelToAddMotelForm(Motel motel){
        AddMotelForm addMotelForm = new AddMotelForm();
        addMotelForm.setTitle(motel.getTitle());
        addMotelForm.setContent(motel.getContent());
        addMotelForm.setShortContent(motel.getShortContent());
        addMotelForm.setMaxPeople(motel.getMaxPeople());
        addMotelForm.setCountBedroom(motel.getCountBedroom());
        addMotelForm.setCountWC(motel.getCountWC());
        addMotelForm.setArea(motel.getArea());
        addMotelForm.setCount(motel.getCount());
        addMotelForm.setCountHired(motel.getCountHired());
        List<Long> listIdGender = genderService.getListIdByMotelId(motel.getId());
        addMotelForm.setLimitGendersId(listIdGender);
        List<Long> listMotelTypeId = motelTypeService.finMotelTypeIdByMotelId(motel.getId());
        addMotelForm.setListMotelTypeId(listMotelTypeId);
        List<Long> listIdAmenitiesIn = amenitiesService.findAmenitiesInIdByMotelId(motel.getId());
        addMotelForm.setListAmenitiesIn(listIdAmenitiesIn);
        List<Long> listIdAmenitiesOut = amenitiesService.findAmenitiesOutIdByMotelId(motel.getId());
        addMotelForm.setListAmenitiesOut(listIdAmenitiesOut);
        Long locationId = locationService.getIdLocationByMotelId(motel.getId());
        addMotelForm.setLocationId(locationId);
        Long projectMotelId = projectMotelService.findIdByMotelId(motel.getId());
        addMotelForm.setProjectMotelId(projectMotelId);
        MotelSubDto motelSubDto = motelService.findInfoSubForMotel(motel.getId());
        if(motelSubDto != null){
            addMotelForm.setPrice(motelSubDto.getPrice());
            addMotelForm.setDeposits(motelSubDto.getDeposits());
            addMotelForm.setTypePayId(motelSubDto.getTypePayId());
        }
        List<Image> listImage = motelService.findImageByMotelId(motel.getId());
        addMotelForm.setListImageOld(listImage);
        addMotelForm.setListIdImageDelete(new ArrayList<>());
        return addMotelForm;
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
