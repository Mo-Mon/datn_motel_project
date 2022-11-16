package com.example.datn_motel_project.controller;

import com.example.datn_motel_project.Constant.listmotel.AmenitiesInConstant;
import com.example.datn_motel_project.Constant.listmotel.AmenitiesOutConstant;
import com.example.datn_motel_project.Constant.listmotel.PriceRange;
import com.example.datn_motel_project.Constant.listmotel.SizeMotelConstant;
import com.example.datn_motel_project.entity.Motel;
import com.example.datn_motel_project.form.ListMotelForm;
import com.example.datn_motel_project.service.LocationService;
import com.example.datn_motel_project.service.MotelService;
import com.example.datn_motel_project.service.MotelTypeService;
import com.example.datn_motel_project.service.TimePayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ListMotelController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private MotelTypeService motelTypeService;

    @Autowired
    private TimePayService timePayService;

    @Autowired
    private MotelService motelService;
    @GetMapping("/home")
    public String goHome(HttpSession session, Model model) {
        ListMotelForm listMotelForm = new ListMotelForm();
        model.addAttribute("listMotelForm", listMotelForm);
        setupView(model);
        getData(model);
        getListRecordPage(model,listMotelForm);
        return "/listmotel";
    }

    private void getListRecordPage(Model model, ListMotelForm listMotelForm) {
        motelService.findListMotelInfo(
                listMotelForm.getTimePay(),
                listMotelForm.getInputTitle(),
                listMotelForm.getInputProject(),
                listMotelForm.getLocation())
    }

    @GetMapping("/home/search")
    @ResponseBody
    public Object search(@ModelAttribute("listMotelForm")ListMotelForm listMotelForm) {
        return listMotelForm;
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
}
