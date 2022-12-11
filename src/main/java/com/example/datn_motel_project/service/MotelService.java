package com.example.datn_motel_project.service;

import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.dto.AccountInfoDto;
import com.example.datn_motel_project.dto.FileSessionDto;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.dto.MotelSubDto;
import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Image;
import com.example.datn_motel_project.entity.Motel;
import com.example.datn_motel_project.entity.PageCustomer;
import com.example.datn_motel_project.form.AddMotelForm;
import javafx.util.Pair;


import java.util.List;

public interface MotelService {
    public PageCustomer<MotelInfoDto> findListMotelInfo(String timePay, String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange,
                                                        List<String> listMotelType, List<String> listAmenities , Integer size, Boolean flag, Integer offset, Integer maxResults);
    public MotelInfoDto getMotelInfoById(Long id);

    public AccountInfoDto getAccountPortMotel(Long id);

    Integer getTotalMotelForAdmin(String title, String location, String project, String nameUserPort);

    List<Motel> findMotelForAdmin(String title, String location, String project, String nameUserPort, Integer offset, Integer maxResults);

    public PageCustomer<MotelInfoDto> findListMotelManagerAccount(String timePay, String inputTitle, String  inputProject, String location, List<PriceRange> listPriceRange, List<String> listMotelType, List<String> listAmenities ,
                                                                  Integer size, Pair<String,String> timePort, List<Integer> listStatus, List<Long> listId, Boolean flag, Integer offset, Integer maxResults, Long accountId);

    void saveMotel(AddMotelForm addMotelForm, Account account, List<FileSessionDto> listImage);


    void deleteMotelId(String id, Long accountId);

    void runQCMotelId(String id, Long accountId);

    Motel findMotelById(Long id);

    MotelSubDto findInfoSubForMotel(Long id);

    List<Image> findImageByMotelId(Long id);
}
