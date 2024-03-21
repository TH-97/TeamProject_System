package com.project.domitory.controller;

import com.project.domitory.noti.service.NotiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotiController {
    @Autowired
    private NotiService notiService;

    @GetMapping("/main")
    public String main(){
        return "mainPage";
    }
    @RequestMapping("/add")
    public String test(){
        return "/AdminPageHtml/postAdmin";
    }
    @PostMapping("/addNoti")
    public String  test2(@RequestParam("bbs_nm")String bbs_nm,
                      @RequestParam("bbs_cn")String bbs_cn
    ){
        System.out.println(bbs_nm);

        return "/AdminPageHtml/postAdmin";
    }

}
