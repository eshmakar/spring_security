package ru.eshmakar.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String getInfoForAllImps(){
        return "view_for_all_employees";
    }

    @GetMapping("/hr_info")
    public String getInfoForOnlyHr(){
        return "view_for_hr";
    }

    @GetMapping("/manager_info")
    public String getInfoForOnlyManagers(){
        return "view_for_managers";
    }
}
