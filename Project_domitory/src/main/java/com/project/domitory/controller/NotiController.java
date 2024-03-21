package com.project.domitory.controller;

import com.project.domitory.noti.service.NotiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotiController {
    @Autowired
    private NotiService notiService;

    @GetMapping("/main")
    public String main(){
        return "mainPage";
    }
}
