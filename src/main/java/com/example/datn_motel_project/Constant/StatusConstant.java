package com.example.datn_motel_project.Constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusConstant {
    WAITING_FOR_APPROVAL(0,"chờ phê duyệt"),
    APPROVED(1,"đã phê duyệt"),
    REGISTER_QC(2,"đăng ký QC"),
    QC(3,"đang chạy QC"),
    CLOSED(4,"đã kết thúc"),
    DELETED(5,"đã xóa");
    private Integer id;
    private String name;
    public static StatusConstant findById(Integer id){
        for(StatusConstant s: StatusConstant.values()){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }
}
