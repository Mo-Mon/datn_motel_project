package com.example.datn_motel_project.repository;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.entity.PageCustomer;
import javafx.util.Pair;

import java.util.List;

public interface MotelInfoRepository {
    public PageCustomer getListIdMotelForSearch(String timePay,String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults);
    public Integer getTotalManagerRecord(String timePay, String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities , Integer size, Pair<String,String> timePort, List<Integer> listStatus, List<Long> listId, Boolean flag,Long accountId);
    public List<Long> getListIdMotelManagerForSearch(String timePay, String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities ,
                                                     Integer size, Pair<String,String> timePort, List<Integer> listStatus, List<Long> listId, Boolean flag, Integer offset, Integer maxResults,Long accountId);
}
