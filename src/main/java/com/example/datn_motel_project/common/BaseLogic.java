package com.example.datn_motel_project.common;

import com.example.datn_motel_project.Constant.Base;
import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.base.BaseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseLogic {
    public static Boolean checkEmptyString(String s){
        return (s == null || "".equals(s));
    }
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Base.FORMAT_DATE);
    public static void setInfoAccountCreate(Account account, BaseEntity baseEntity){
        baseEntity.setCreateAt(new Date());
        baseEntity.setUpdateAt(new Date());
        baseEntity.setUpdateBy(account.getFullName());
        baseEntity.setCreateBy(account.getFullName());
        baseEntity.setDeleteFlag(false);
    }
    public static void setInfoAccountUpdate(Account account, BaseEntity baseEntity){
        baseEntity.setUpdateAt(new Date());
        baseEntity.setUpdateBy(account.getFullName());
    }
    public static void deleteLogicEnity(Account account, BaseEntity baseEntity){
        baseEntity.setUpdateAt(new Date());
        baseEntity.setUpdateBy(account.getFullName());
        baseEntity.setDeleteFlag(true);
    }

    public static Date getStringToDate(String s) throws ParseException {
        return simpleDateFormat.parse(s);
    }

    public static Integer getOffset(Integer pageCurrent){
        return (pageCurrent - 1) * Base.MAX_RECORD_IN_PAGE;
    }

    public static Integer getPage(Integer offset){
        return offset/Base.MAX_RECORD_IN_PAGE + 1;
    }

    public static List<Integer> getListPaging(int totalPage,  int currentPage) {
        List<Integer> listPaging = new ArrayList<>();
        int index = (currentPage - 1) / Base.LIMIT_PAGING;
        int i = 0;
        while (i < Base.LIMIT_PAGING && (index * Base.LIMIT_PAGING + 1) + i <= totalPage) {
            listPaging.add((index * Base.LIMIT_PAGING + 1) + i);
            i++;
        }
        return listPaging;
    }

    public static String convertDateForDB(String date) throws ParseException {
        final String OLD_FORMAT = "MM/dd/yyyy";
        final String NEW_FORMAT = "yyyy-MM`-dd";
        String oldDateString = date;
        String newDateString;

        SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
        Date d = sdf.parse(oldDateString);
        sdf.applyPattern(NEW_FORMAT);
        newDateString = sdf.format(d);
        return newDateString;
    }
}
