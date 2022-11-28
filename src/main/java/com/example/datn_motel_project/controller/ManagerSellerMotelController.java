package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.Constant.Base;
import com.example.datn_motel_project.Constant.StatusConstant;
import com.example.datn_motel_project.Constant.listmotel.AmenitiesInConstant;
import com.example.datn_motel_project.Constant.listmotel.AmenitiesOutConstant;
import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.Constant.listmotel.SizeMotelConstant;
import com.example.datn_motel_project.common.BaseLogic;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.entity.PageCustomer;
import com.example.datn_motel_project.form.ListMotelManagerForm;
import com.example.datn_motel_project.service.LocationService;
import com.example.datn_motel_project.service.MotelService;
import com.example.datn_motel_project.service.MotelTypeService;
import com.example.datn_motel_project.service.TimePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javafx.util.Pair;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class ManagerSellerMotelController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private MotelTypeService motelTypeService;

    @Autowired
    private TimePayService timePayService;

    @Autowired
    private MotelService motelService;

    @GetMapping("/managerMotel")
    public String init(Model model, HttpSession session){
        ListMotelManagerForm listMotelManagerForm = new ListMotelManagerForm();
//        listMotelManagerForm.setTimePay(timePayService.getListStringTimePay().get(0));
        model.addAttribute("listMotelManagerForm", listMotelManagerForm);
        setupView(model);
        getData(model);
        Long accountId = (Long) session.getAttribute("accountId");
        getListRecordPage(accountId,model,listMotelManagerForm);
        return "managermotel";
    }
    @GetMapping(value = "/managerMotel", params = { "action=search" })
    public String search(@ModelAttribute("listMotelManagerForm") ListMotelManagerForm listMotelManagerForm, Model model, HttpSession session) {
        model.addAttribute("listMotelManagerForm", listMotelManagerForm);
        setupView(model);
        getData(model);
        Long accountId = (Long) session.getAttribute("accountId");
        getListRecordPage(accountId,model,listMotelManagerForm);
        return "managermotel";
    }
    private void setupView(Model model) {
        model.addAttribute("listPriceRange", PriceRange.values());
        model.addAttribute("listAmenitiesIn", AmenitiesInConstant.values());
        model.addAttribute("listAmenitiesOut", AmenitiesOutConstant.values());
        model.addAttribute("listSize", SizeMotelConstant.values());
        model.addAttribute("listStatus", StatusConstant.values());
    }

    private void getData(Model model) {
        List<String> locations = locationService.getListLocation();
        model.addAttribute("listLocation", locations);
        List<String> motelTypes = motelTypeService.getAllNameMotelType();
        model.addAttribute("listMotelType", motelTypes);
        List<String> timePays = timePayService.getListStringTimePay();
        model.addAttribute("listTimePay",timePays);
    }

    private void getListRecordPage(Long accountId,Model model, ListMotelManagerForm listMotelManagerForm) {
        List<PriceRange> priceRanges = PriceRange.getListPriceRangeById(listMotelManagerForm.getListPriceRange());
        List<String> listAmenities = new ArrayList<>();
        listAmenities.addAll(listMotelManagerForm.getListAmenitiesIn());
        listAmenities.addAll(listMotelManagerForm.getListAmenitiesOut());
        Pair<String, String> timePort = null;
        if(BaseLogic.checkEmptyString(listMotelManagerForm.getStartDate()) && BaseLogic.checkEmptyString(listMotelManagerForm.getEndDate())){
            timePort = new Pair<>(listMotelManagerForm.getStartDate(),listMotelManagerForm.getEndDate());
        }
        PageCustomer<MotelInfoDto> pageCustomer =  motelService.findListMotelManagerAccount(
                listMotelManagerForm.getTimePay(),
                listMotelManagerForm.getInputTitle(),
                listMotelManagerForm.getInputProject(),
                listMotelManagerForm.getLocation(),
                priceRanges,
                listMotelManagerForm.getListMotelType(),
                listAmenities,
                listMotelManagerForm.getSize(),
                timePort,
                listMotelManagerForm.getListStatus(),
                listMotelManagerForm.getListId(),
                true,
                BaseLogic.getOffset(listMotelManagerForm.getPageCurrent()) , Base.MAX_RECORD_IN_PAGE,
                accountId
        );
        model.addAttribute("pageCustomer",pageCustomer);
        List<Integer> listPage = BaseLogic.getListPaging(pageCustomer.getTotalPage(),listMotelManagerForm.getPageCurrent());
        model.addAttribute("listPage", listPage);
    }
}
