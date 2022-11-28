package com.example.datn_motel_project.service;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.entity.PageCustomer;
import javafx.util.Pair;


import java.util.List;

public interface MotelService {
    public PageCustomer<MotelInfoDto> findListMotelInfo(String timePay, String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange,
                                                        List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults);
    public MotelInfoDto getMotelInfoById(Long id);

    public AccountInfoDto getAccountPortMotel(Long id);

    public PageCustomer<MotelInfoDto> findListMotelManagerAccount(String timePay, String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities ,
                                                                  Integer size, Pair<String,String> timePort, List<Integer> listStatus, List<Long> listId, Boolean flag, Integer offset, Integer maxResults,Long accountId);
}
