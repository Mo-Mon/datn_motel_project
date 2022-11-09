package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.entity.PageCustomer;

import java.util.List;

public interface MotelInfoRepository {
    public PageCustomer getListIdMotelForSearch(String timePay,String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults);
}
