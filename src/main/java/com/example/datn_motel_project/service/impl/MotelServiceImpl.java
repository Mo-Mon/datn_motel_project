package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.Constant.StatusConstant;
import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.common.BaseLogic;
import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.FileSessionDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.dto.MotelSubDto;
import com.example.datn_motel_project.entity.*;
import com.example.datn_motel_project.form.AddMotelForm;
import com.example.datn_motel_project.repository.*;
import com.example.datn_motel_project.service.ImageService;
import com.example.datn_motel_project.service.MotelService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class MotelServiceImpl implements MotelService {
    @Autowired
    private MotelInfoRepository motelInfoRepository;

    @Autowired
    private MotelRepository motelRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private MotelTypeRepository motelTypeRepository;

    @Autowired
    private AmenitiesRepository amenitiesRepository;

    @Autowired
    private ImageService imageService;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private TimePayRepository timePayRepository;

    @Autowired
    private ProjectMotelRepository projectMotelRepository;

    @Autowired
    private MotelPayinfoDetailRepository motelPayinfoDetailRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Integer getTotalMotelForAdmin(String title , String location, String project, String nameUserPort){
        return motelInfoRepository.getTotalMotelAdmin(title ,location, project, nameUserPort);
    }

    @Override
    public List<Motel> findMotelForAdmin(String title, String location, String project, String nameUserPort, Integer offset, Integer maxResults){
        return motelInfoRepository.getListMotelAdmin( title, location, project, nameUserPort, offset, maxResults);
    }

    public PageCustomer<MotelInfoDto> findListMotelManagerAccount(String timePay, String inputTitle, String inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities,
                                                                  Integer size, Pair<String, String> timePort, List<Integer> listStatus, List<Long> listId, Boolean flag, Integer offset, Integer maxResults, Long accountId) {
        Integer totalRecord = motelInfoRepository.getTotalManagerRecord(timePay, inputTitle, inputProject, location, listPriceRange, listMotelType, listAmenities, size, timePort, listStatus, listId, flag, accountId);
        List<Long> listIdMotel = motelInfoRepository.getListIdMotelManagerForSearch(timePay, inputTitle, inputProject, location, listPriceRange, listMotelType, listAmenities, size, timePort, listStatus, listId, flag, offset, maxResults, accountId);
        PageCustomer<MotelInfoDto> pageCustomer = new PageCustomer<>();
        List<MotelInfoDto> motelInfoDtos = new ArrayList<>();
        for (Long id : listIdMotel) {
            Motel motel = motelRepository.findById(id).get();
            MotelInfoDto motelInfoDto = new MotelInfoDto();
            motelInfoDto.setTypePay(timePay);
            covertMotelToMotelInfo(motel, motelInfoDto, true);
            motelInfoDtos.add(motelInfoDto);
        }
        pageCustomer.setListObject(motelInfoDtos);
        pageCustomer.setPage(BaseLogic.getPage(offset));
        pageCustomer.setTotalRecord(totalRecord);
        pageCustomer.setLimitRecordInPage(maxResults);
        pageCustomer.setTotalPage((pageCustomer.getTotalRecord() - 1) / pageCustomer.getLimitRecordInPage() + 1);
        return pageCustomer;
    }

    public PageCustomer<MotelInfoDto> findListMotelInfo(String timePay, String inputTitle, String inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities, Integer size, Boolean flag, Integer offset, Integer maxResults) {
        PageCustomer<Long> pageCustomerId = motelInfoRepository.getListIdMotelForSearch(timePay, inputTitle, inputProject, location, listPriceRange, listMotelType, listAmenities, size, flag, offset, maxResults);
        PageCustomer<MotelInfoDto> pageCustomer = new PageCustomer<>();
        List<MotelInfoDto> motelInfoDtos = new ArrayList<>();
        for (Long id : pageCustomerId.getListObject()) {
            Motel motel = motelRepository.findById(id).get();
            MotelInfoDto motelInfoDto = new MotelInfoDto();
            motelInfoDto.setTypePay(timePay);
            covertMotelToMotelInfo(motel, motelInfoDto, false);
            motelInfoDtos.add(motelInfoDto);
        }
        pageCustomer.setListObject(motelInfoDtos);
        pageCustomer.setPage(BaseLogic.getPage(offset));
        pageCustomer.setTotalPage(pageCustomerId.getTotalPage());
        pageCustomer.setLimitRecordInPage(maxResults);
        pageCustomer.setTotalRecord(pageCustomerId.getTotalRecord());
        return pageCustomer;
    }

    public MotelInfoDto getMotelInfoById(Long id) {
        Motel motel = motelRepository.findById(id).get();
        MotelInfoDto motelInfoDto = new MotelInfoDto();
        covertMotelToMotelInfo(motel, motelInfoDto, false);
        return motelInfoDto;
    }

    @Override
    public AccountInfoDto getAccountPortMotel(Long id) {
        return motelRepository.getAccountPortMotel(id);
    }

    @Override
    public void saveMotel(AddMotelForm addMotelForm, Account account, List<FileSessionDto> listImage) {
        Motel motel = covertAddMotelForm(addMotelForm);
        BaseLogic.setInfoAccountCreate(account, motel);
        motel.setAccount(account);
        if(!BaseLogic.checkEmptyString(addMotelForm.getId())){
            motel.setId(Long.parseLong(addMotelForm.getId()));
            if(addMotelForm.getListIdImageDelete() != null){
                for(Long id: addMotelForm.getListIdImageDelete()){
                    Image image = imageRepository.findById(id).get();
                    if(image != null){
                        BaseLogic.setInfoAccountUpdate(account,image);
                        image.setDeleteFlag(true);
                        imageRepository.save(image);
                    }
                }
            }

        }
        motelRepository.save(motel);
        for (FileSessionDto fileSessionDto : listImage) {
            Image image = imageService.storeFileInSession(fileSessionDto, account);
            image.setMotel(motel);
            imageRepository.save(image);
        }
        MotelPayInfoDetail motelPayInfoDetail = new MotelPayInfoDetail();
        BaseLogic.setInfoAccountCreate(account, motelPayInfoDetail);
        motelPayInfoDetail.setPrice(addMotelForm.getPrice());
        motelPayInfoDetail.setDeposits(addMotelForm.getDeposits());
        motelPayInfoDetail.setMotel(motel);
        TimePay timePay = timePayRepository.findById(addMotelForm.getTypePayId()).get();
        motelPayInfoDetail.setTimePay(timePay);
        motelPayinfoDetailRepository.save(motelPayInfoDetail);
    }

    @Override
    public void deleteMotelId(String id, Long accountId){
        Account account = accountRepository.findById(accountId).get();
        Long motelId = Long.parseLong(id);
        Motel motel = motelRepository.findById(motelId).get();
        motel.setDeleteFlag(true);
        BaseLogic.setInfoAccountUpdate(account,motel);
        Set<MotelPayInfoDetail> motelPayInfoDetails = motel.getMotelPayInfoDetails();
        for(MotelPayInfoDetail item: motelPayInfoDetails){
            item.setDeleteFlag(true);
            BaseLogic.setInfoAccountUpdate(account,item);
            motelPayinfoDetailRepository.save(item);
        }
        motelRepository.save(motel);
    }

    @Override
    public void runQCMotelId(String id, Long accountId){
        Account account = accountRepository.findById(accountId).get();
        Long motelId = Long.parseLong(id);
        Motel motel = motelRepository.findById(motelId).get();
        motel.setStatus(StatusConstant.REGISTER_QC.getId());
        BaseLogic.setInfoAccountUpdate(account,motel);
        motelRepository.save(motel);
    }

    private Motel covertAddMotelForm(AddMotelForm addMotelForm) {
        Motel motel = new Motel();
        motel.setTitle(addMotelForm.getTitle());
        motel.setShortContent(addMotelForm.getShortContent());
        motel.setContent(addMotelForm.getContent());
        motel.setMaxPeople(addMotelForm.getMaxPeople());
        motel.setCountBedroom(addMotelForm.getCountBedroom());
        motel.setCountWC(addMotelForm.getCountWC());
        motel.setCount(addMotelForm.getCount());
        motel.setArea(addMotelForm.getArea());
        motel.setCountHired(0);
        motel.setStatus(0);
        for (Long id : addMotelForm.getLimitGendersId()) {
            Gender gender = genderRepository.findById(id).get();
            motel.getLimitGenders().add(gender);
        }
        for (Long id : addMotelForm.getListMotelTypeId()) {
            MotelType motelType = motelTypeRepository.findById(id).get();
            motel.getMotelTypes().add(motelType);
        }

        for (Long id : addMotelForm.getListAmenitiesIn()) {
            Amenities amenitiesIn = amenitiesRepository.findAllById(id);
            motel.getAmenities().add(amenitiesIn);
        }

        for (Long id : addMotelForm.getListAmenitiesOut()) {
            Amenities amenitiesOut = amenitiesRepository.findAllById(id);
            motel.getAmenities().add(amenitiesOut);
        }

        Location location = locationRepository.findById(addMotelForm.getLocationId()).get();
        motel.setLocation(location);

        ProjectMotel projectMotel = projectMotelRepository.findById(addMotelForm.getProjectMotelId()).get();
        motel.setProjectMotel(projectMotel);
        return motel;
    }

    private void covertMotelToMotelInfo(Motel motel, MotelInfoDto motelInfoDto, Boolean flagStatus) {
        motelInfoDto.setId(motel.getId());
        motelInfoDto.setTitle(motel.getTitle());
        motelInfoDto.setShortContent(motel.getShortContent());
        motelInfoDto.setContent(motel.getContent());
        motelInfoDto.setMaxPeople(motel.getMaxPeople());
        motelInfoDto.setCountBedroom(motel.getCountBedroom());
        motelInfoDto.setCountWC(motel.getCountWC());
        motelInfoDto.setArea(motel.getArea());
        motelInfoDto.setCount(motel.getCount());
        motelInfoDto.setCountHired(motel.getCountHired());
        List<Image> images = new ArrayList<>(motel.getImages());
        motelInfoDto.setListImage(images);
        Set<String> listLimitGenders = new LinkedHashSet<>();
        for (Gender gender : motel.getLimitGenders()) {
            listLimitGenders.add(gender.getName());
        }
        motelInfoDto.setLimitGenders(listLimitGenders);
        Set<String> listMotelType = new LinkedHashSet<>();
        for (MotelType motelType : motel.getMotelTypes()) {
            listMotelType.add(motelType.getName());
        }
        motelInfoDto.setListMotelType(listMotelType);
        motelInfoDto.setListAmenities(motel.getAmenities());

        motelInfoDto.setLocationName(motel.getLocation() == null ? "" : motel.getLocation().getName());
        for (MotelPayInfoDetail motelPayInfoDetail : motel.getMotelPayInfoDetails()) {
            if (BaseLogic.checkEmptyString(motelInfoDto.getTypePay()) || motelInfoDto.getTypePay().equals(motelPayInfoDetail.getTimePay().getTypeTime())) {
                motelInfoDto.setPrice(motelPayInfoDetail.getPrice());
            }
        }
        motelInfoDto.setProjectType(motel.getProjectMotel().getName());
        motelInfoDto.setNameUserPort(motel.getCreateBy());
        motelInfoDto.setTimePort(motel.getCreateAt());
        if (flagStatus) {
            StatusConstant s = StatusConstant.findById((Integer) motel.getStatus());
            motelInfoDto.setStatus(s != null ? s.getName() : "");
        }
        List<Image> listImage = new ArrayList<>();
        for(Image image: motel.getImages()){
            listImage.add(image);
        }
        motelInfoDto.setListImage(listImage);
    }

    @Override
    public Motel findMotelById(Long id){
        return motelRepository.findById(id).get();
    }

    @Override
    public MotelSubDto findInfoSubForMotel(Long id){
        return motelRepository.findInfoSubByMotelId(id);
    }

    @Override
    public List<Image> findImageByMotelId(Long id){
        return imageRepository.findImageByMotelId(id);
    }
}
