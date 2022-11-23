package com.example.datn_motel_project.service.impl;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.entity.*;
import com.example.datn_motel_project.repository.MotelInfoRepository;
import com.example.datn_motel_project.repository.MotelRepository;
import com.example.datn_motel_project.service.MotelService;
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

    public PageCustomer<MotelInfoDto> findListMotelInfo(String timePay,String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults){
        PageCustomer<Long> pageCustomerId = motelInfoRepository.getListIdMotelForSearch(timePay,inputTitle,inputProject, location, listPriceRange, listMotelType,  listAmenities , size, flag, offset, maxResults);
        PageCustomer<MotelInfoDto> pageCustomer = new PageCustomer<>();
        List<MotelInfoDto> motelInfoDtos = new ArrayList<>();
        for(Long id : pageCustomerId.getListObject()){
            Motel motel = motelRepository.findById(id).get();
            MotelInfoDto motelInfoDto = new MotelInfoDto();
            motelInfoDto.setTypePay(timePay);
            covertMotelToMotelInfo(motel, motelInfoDto);
            motelInfoDtos.add(motelInfoDto);
        }
        pageCustomer.setListObject(motelInfoDtos);
        pageCustomer.setPage(offset);
        pageCustomer.setTotalPage(pageCustomerId.getTotalPage());
        pageCustomer.setLimitRecordInPage(maxResults);
        pageCustomer.setTotalRecord(pageCustomerId.getTotalRecord());
        return pageCustomer;
    }

    public MotelInfoDto getMotelInfoById(Long id){
        Motel motel = motelRepository.findById(id).get();
        MotelInfoDto motelInfoDto = new MotelInfoDto();
        covertMotelToMotelInfo(motel,motelInfoDto);
        return motelInfoDto;
    }

    @Override
    public AccountInfoDto getAccountPortMotel(Long id) {
        return motelRepository.getAccountPortMotel(id);
    }

    private void covertMotelToMotelInfo(Motel motel, MotelInfoDto motelInfoDto){
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

        motelInfoDto.setLocationName(motel.getLocation() == null?"":motel.getLocation().getName());
        for(MotelPayInfoDetail motelPayInfoDetail: motel.getMotelPayInfoDetails()){
            if(motelInfoDto.getTypePay().equals(motelPayInfoDetail.getTimePay().getTypeTime())){
                motelInfoDto.setPrice(motelPayInfoDetail.getPrice());
            }
        }
        motelInfoDto.setProjectType(motel.getProjectMotel().getName());
        motelInfoDto.setNameUserPort(motel.getCreateBy());
        motelInfoDto.setTimePort(motel.getCreateAt());
    }
}
