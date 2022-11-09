package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.entity.Gender;
import com.example.datn_motel_project.entity.Motel;
import com.example.datn_motel_project.entity.MotelType;
import com.example.datn_motel_project.entity.PageCustomer;
import com.example.datn_motel_project.repository.MotelInfoRepository;
import com.example.datn_motel_project.repository.MotelRepository;
import com.example.datn_motel_project.service.MotelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MotelServiceImpl implements MotelService {
    @Autowired
    private MotelInfoRepository motelInfoRepository;

    @Autowired
    private MotelRepository motelRepository;

    public PageCustomer<MotelInfoDto> findListMotelInfo(String timePay,String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults){
        PageCustomer<Long> pageCustomerId = motelInfoRepository.getListIdMotelForSearch(timePay,inputTitle,inputProject, location, listPriceRange, listMotelType,  listAmenities , size, flag, offset, maxResults);
        PageCustomer<MotelInfoDto> pageCustomer = new PageCustomer<>();
        for(Long id : pageCustomerId.getListObject()){
            Motel motel = motelRepository.findById(id).get();
            MotelInfoDto motelInfoDto = new MotelInfoDto();
            covertMotelToMotelInfo(motel, motelInfoDto);
        }
        return null;
    }
    private void covertMotelToMotelInfo(Motel motel, MotelInfoDto motelInfoDto){
        motelInfoDto.setTitle(motel.getTitle());
        motelInfoDto.setShortContent(motel.getShortContent());
        motelInfoDto.setContent(motel.getContent());
        motelInfoDto.setMaxPeople(motel.getMaxPeople());
        motelInfoDto.setCountBedroom(motel.getCountBedroom());
        motelInfoDto.setCountWC(motel.getCountWC());
        motelInfoDto.setArea(motel.getArea());
        motelInfoDto.setCount(motel.getCount());

        motelInfoDto.setListImage(motel.getImages());
        Set<String> listLimitGenders = new LinkedHashSet<>();
        for(Gender gender: motel.getLimitGenders()){
            listLimitGenders.add(gender.getName());
        }
        motelInfoDto.setLimitGenders(listLimitGenders);
        Set<String> listMotelType = new LinkedHashSet<>();
        for(MotelType motelType: motel.getMotelTypes()){
            listMotelType.add(motelType.getName());
        }
        motelInfoDto.setListMotelType(listMotelType);
        motelInfoDto.setListAmenities(motel.getAmenities());

        motelInfoDto.setLocationName(motel.getLocation().getName());
        motelInfoDto.setPrice(null);
        motelInfoDto.setTypePay(null);
    }
}
