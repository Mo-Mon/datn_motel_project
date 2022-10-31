package com.example.datn_motel_project.form;

import com.example.datn_motel_project.Constant.header.AccountHeader;
import com.example.datn_motel_project.Constant.header.HeaderInfo;
import com.example.datn_motel_project.Constant.header.ScreenInfo;
import com.example.datn_motel_project.entity.Account;
import com.example.datn_motel_project.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HeaderForm {
    private List<HeaderInfoForm> headers = new ArrayList<>();
    private List<AccountHeader> accountInfo = Arrays.asList(AccountHeader.values());

    public static HeaderForm build(Account account) {
        List<AccountHeader> accountInfo = Arrays.asList(AccountHeader.values());
        List<HeaderInfoForm> headers = new ArrayList<>();
        for (HeaderInfo h : HeaderInfo.values()) {
            HeaderInfoForm headerInfoForm = new HeaderInfoForm();
            headerInfoForm.setTitle(h.getHeaderName());
            headerInfoForm.setScreens(getListScreenByRole(account.getRoles(), h));
            if(headerInfoForm.getScreens().size() > 0)
            headers.add(headerInfoForm);
        }
        return new HeaderForm(headers, accountInfo);
    }

    private static List<ScreenInfo> getListScreenByRole(Set<Role> listRole, HeaderInfo h) {
        List<ScreenInfo> screenInfos = new ArrayList<>();
        for (ScreenInfo screenInfo : h.getScreens()) {
            for (Role role :  listRole) {
                System.out.println(role.getRoleName());
                if (role.getRoleName().equals(screenInfo.getRoles())){
                    screenInfos.add(screenInfo);
                }
            }
        }
        return screenInfos;
    }

    @Data
    static class HeaderInfoForm {
        private String title;
        private List<ScreenInfo> screens;
    }
}
