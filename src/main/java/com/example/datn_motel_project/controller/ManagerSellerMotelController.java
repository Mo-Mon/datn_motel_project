package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.Constant.Base;
import com.example.datn_motel_project.Constant.listmotel.AmenitiesInConstant;
import com.example.datn_motel_project.Constant.listmotel.AmenitiesOutConstant;
import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.Constant.listmotel.SizeMotelConstant;
import com.example.datn_motel_project.common.BaseLogic;
import com.example.datn_motel_project.dto.MotelInfoDto;
import com.example.datn_motel_project.entity.PageCustomer;
import com.example.datn_motel_project.form.ListMotelForm;
import com.example.datn_motel_project.service.LocationService;
import com.example.datn_motel_project.service.MotelService;
import com.example.datn_motel_project.service.MotelTypeService;
import com.example.datn_motel_project.service.TimePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String init(Model model){
        ListMotelForm listMotelForm = new ListMotelForm();
        listMotelForm.setTimePay(timePayService.getListStringTimePay().get(0));
        model.addAttribute("listMotelForm", listMotelForm);
        setupView(model);
        getData(model);
        getListRecordPage(model,listMotelForm);
        return "managermotel";
    }
    private void setupView(Model model) {
        model.addAttribute("listPriceRange", PriceRange.values());
        model.addAttribute("listAmenitiesIn", AmenitiesInConstant.values());
        model.addAttribute("listAmenitiesOut", AmenitiesOutConstant.values());
        model.addAttribute("listSize", SizeMotelConstant.values());
    }

    private void getData(Model model) {
        List<String> locations = locationService.getListLocation();
        model.addAttribute("listLocation", locations);
        List<String> motelTypes = motelTypeService.getAllNameMotelType();
        model.addAttribute("listMotelType", motelTypes);
        List<String> timePays = timePayService.getListStringTimePay();
        model.addAttribute("listTimePay",timePays);
    }

    private void getListRecordPage(Model model, ListMotelForm listMotelForm) {
        List<PriceRange> priceRanges = PriceRange.getListPriceRangeById(listMotelForm.getListPriceRange());
        List<String> listAmenities = new ArrayList<>();
        listAmenities.addAll(listMotelForm.getListAmenitiesIn());
        listAmenities.addAll(listMotelForm.getListAmenitiesOut());
        PageCustomer<MotelInfoDto> pageCustomer =  motelService.findListMotelInfo(
                listMotelForm.getTimePay(),
                listMotelForm.getInputTitle(),
                listMotelForm.getInputProject(),
                listMotelForm.getLocation(),
                priceRanges,
                listMotelForm.getListMotelType(),
                listAmenities,
                listMotelForm.getSize(),
                true,
                BaseLogic.getOffset(listMotelForm.getPageCurrent()) , Base.MAX_RECORD_IN_PAGE
        );
        model.addAttribute("pageCustomer",pageCustomer);
        List<Integer> listPage = BaseLogic.getListPaging(pageCustomer.getTotalPage(),listMotelForm.getPageCurrent());
        model.addAttribute("listPage", listPage);
    }
}
