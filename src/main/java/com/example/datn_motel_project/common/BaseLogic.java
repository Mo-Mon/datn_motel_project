package com.example.datn_motel_project.common;

import com.example.datn_motel_project.Constant.Base;
import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.base.BaseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseLogic {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Base.formatDate);
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

}
