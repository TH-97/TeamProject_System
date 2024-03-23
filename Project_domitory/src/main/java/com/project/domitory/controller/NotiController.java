package com.project.domitory.controller;

import com.project.domitory.command.NotiVO;
import com.project.domitory.noti.service.NotiService;
import com.project.domitory.user.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        return "AdminPageHtml/postAdmin";
    }
    @PostMapping("/addNoti")
    public String   test2(@RequestParam("bbs_nm")String bbs_nm,
                      @RequestParam("bbs_cn")String bbs_cn
    ){
        System.out.println(bbs_nm);
        notiService.addNoti(bbs_nm,bbs_cn);

        return "AdminPageHtml/postAdmin";
    }
    @GetMapping("/delectNoti")
    public String test3(@RequestParam("bbs_sn")Integer bbs_sn, Model model){
        notiService.delectNoti(bbs_sn);

        List<NotiVO> list = notiService.notiList();

        model.addAttribute("list",list);

        return "AdminPageHtml/noticeInquiry";
    }

    @PostMapping("/notiList")
    public String test4(Model model){

        List<NotiVO> list = notiService.notiList();

        model.addAttribute("list",list);
        return "AdminPageHtml/noticeInquiry";
    }

    @PostMapping("/songList")
    public String test5(Model model){

        List<NotiVO> list = notiService.songList();

        model.addAttribute("song",list);
        return "AdminPageHtml/noticeInquiry";
    }

    @PostMapping("/deletSong")
    public String test6(@RequestParam("song_no")Integer song_no,Model model){

        notiService.deletSong(song_no);

        List<NotiVO> list = notiService.songList();

        model.addAttribute("song",list);
        return "AdminPageHtml/noticeInquiry";
    }

    @PostMapping("/addSong")
    public String test7(@RequestParam("title")String title, Authentication authentication){
        MyUserDetails detail = (MyUserDetails) authentication.getPrincipal();
        String stud_no = detail.getUsername();

        notiService.addSong(stud_no,title);

        return "mainPage";
    }

}
