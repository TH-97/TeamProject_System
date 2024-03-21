package com.project.domitory.Adminpage.controller;

import com.project.domitory.Adminpage.service.StudentService;
import com.project.domitory.command.AdminVO;
import com.project.domitory.command.BuildingVO;
import com.project.domitory.command.FloorVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminPageController {

    @Autowired
    @Qualifier("StudentServiceImpl")
    //컨트롤러의 다음 흐름은 바로 service이기때문에 @Qualifier를 이용하여 지정해서 바로가져온다
    private StudentService studentService;

	/*
	 * @GetMapping("/") public String adminPage() {
	 * 
	 * return "AdminPageHtml/adminMainPage"; }
	 */

    @PostMapping("/selectStudent")
    public String test(@RequestParam("name") String name, Model model) {
        AdminVO vo = new AdminVO();
        //파라미터로 값을 기져와서 이름을 vo에 저장한다
        vo.setUser_nm(name);
        //db에서 가져온 list를 list에 저장한다
        List<AdminVO> list = studentService.getname(vo);
        //model에 list라는 이름으로 저장한다
        model.addAttribute("list", list);
        return "AdminPageHtml/roomAssignment";
    }

    @RequestMapping("/buildingFloor")
    public String test2(@RequestParam("gndr_nm") String gndr_nm, Model model) {
        BuildingVO vo = new BuildingVO();
        if (gndr_nm.equals("M")) {
            vo.setBldg_nm("남자관");
        } else vo.setBldg_nm("여자관");
        List<BuildingVO> list = studentService.getBuliding(vo);
        model.addAttribute("list", list);
        return "AdminPageHtml/buildingFloor";
    }

    @RequestMapping("room")
    public String test3(@RequestParam("bldg_cd") String bldg_cd, Model model) {
        FloorVO vo = new FloorVO();
        vo.setBldg_cd(bldg_cd);
        List<FloorVO> list = studentService.getFloor(vo);
        model.addAttribute("list", list);
        return "AdminPageHtml/room";
    }

    @PostMapping("/modify")
    public String test4(@RequestParam("stud_no") String stud_no,
                        @RequestParam("name") String name,
                        @RequestParam("altmnt_rm_cd") String altmnt_rm_cd
    ) {
        studentService.setRoom(altmnt_rm_cd, stud_no);
        studentService.setRoom2(altmnt_rm_cd);
        return "AdminPageHtml/room";
    }

    @PostMapping("/test")
    public String test5() {
        studentService.auto();
        return "AdminPageHtml/roomAssignment";
    }
    @PostMapping("/reset")
    public String reset(){
        studentService.reset();
        return "AdminPageHtml/roomAssignment";
    }

    @RequestMapping("/suggestInquiry")
    public String test11(){
        return "AdminPageHtml/noticeInquiry";
    }

    @RequestMapping(value = "/A1F")
    public String test6(Model model) {
        List<AdminVO> list = studentService.getUserRoom();
        List<AdminVO> list1 = new ArrayList<>();
        List<AdminVO> list2 = new ArrayList<>();
        List<AdminVO> list3 = new ArrayList<>();
        List<AdminVO> list4 = new ArrayList<>();
        List<AdminVO> list5 = new ArrayList<>();
        List<AdminVO> list6 = new ArrayList<>();
        List<AdminVO> list7 = new ArrayList<>();
        List<AdminVO> list8 = new ArrayList<>();
        List<AdminVO> list9 = new ArrayList<>();
        List<AdminVO> list10 = new ArrayList<>();


        for (AdminVO vo : list) {
            if (vo.getAltmnt_rm_cd() == 101) list1.add(vo);
            if (vo.getAltmnt_rm_cd() == 102) list2.add(vo);
            if (vo.getAltmnt_rm_cd() == 103) list3.add(vo);
            if (vo.getAltmnt_rm_cd() == 104) list4.add(vo);
            if (vo.getAltmnt_rm_cd() == 105) list5.add(vo);
            if (vo.getAltmnt_rm_cd() == 106) list6.add(vo);
            if (vo.getAltmnt_rm_cd() == 107) list7.add(vo);
            if (vo.getAltmnt_rm_cd() == 108) list8.add(vo);
            if (vo.getAltmnt_rm_cd() == 109) list9.add(vo);
            if (vo.getAltmnt_rm_cd() == 110) list10.add(vo);
        }


        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
        model.addAttribute("list6", list6);
        model.addAttribute("list7", list7);
        model.addAttribute("list8", list8);
        model.addAttribute("list9", list9);
        model.addAttribute("list10", list10);
        return "AdminPageHtml/floor/A1F";
    }

    @RequestMapping(value = "/A2F")
    public String test7(Model model) {
        List<AdminVO> list = studentService.getUserRoom2();
        List<AdminVO> list1 = new ArrayList<>();
        List<AdminVO> list2 = new ArrayList<>();
        List<AdminVO> list3 = new ArrayList<>();
        List<AdminVO> list4 = new ArrayList<>();
        List<AdminVO> list5 = new ArrayList<>();
        List<AdminVO> list6 = new ArrayList<>();
        List<AdminVO> list7 = new ArrayList<>();
        List<AdminVO> list8 = new ArrayList<>();
        List<AdminVO> list9 = new ArrayList<>();
        List<AdminVO> list10 = new ArrayList<>();
        for (AdminVO vo : list) {
            if (vo.getAltmnt_rm_cd() == 101) list1.add(vo);
            if (vo.getAltmnt_rm_cd() == 102) list2.add(vo);
            if (vo.getAltmnt_rm_cd() == 103) list3.add(vo);
            if (vo.getAltmnt_rm_cd() == 104) list4.add(vo);
            if (vo.getAltmnt_rm_cd() == 105) list5.add(vo);
            if (vo.getAltmnt_rm_cd() == 106) list6.add(vo);
            if (vo.getAltmnt_rm_cd() == 107) list7.add(vo);
            if (vo.getAltmnt_rm_cd() == 108) list8.add(vo);
            if (vo.getAltmnt_rm_cd() == 109) list9.add(vo);
            if (vo.getAltmnt_rm_cd() == 110) list10.add(vo);
        }
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
        model.addAttribute("list6", list6);
        model.addAttribute("list7", list7);
        model.addAttribute("list8", list8);
        model.addAttribute("list9", list9);
        model.addAttribute("list10", list10);
        return "AdminPageHtml/floor/A2F";
    }

    @RequestMapping(value = "/A3F")
    public String test8(Model model) {
        List<AdminVO> list = studentService.getUserRoom3();
        List<AdminVO> list1 = new ArrayList<>();
        List<AdminVO> list2 = new ArrayList<>();
        List<AdminVO> list3 = new ArrayList<>();
        List<AdminVO> list4 = new ArrayList<>();
        List<AdminVO> list5 = new ArrayList<>();
        List<AdminVO> list6 = new ArrayList<>();
        List<AdminVO> list7 = new ArrayList<>();
        List<AdminVO> list8 = new ArrayList<>();
        List<AdminVO> list9 = new ArrayList<>();
        List<AdminVO> list10 = new ArrayList<>();
        for (AdminVO vo : list) {
            if (vo.getAltmnt_rm_cd() == 101) list1.add(vo);
            if (vo.getAltmnt_rm_cd() == 102) list2.add(vo);
            if (vo.getAltmnt_rm_cd() == 103) list3.add(vo);
            if (vo.getAltmnt_rm_cd() == 104) list4.add(vo);
            if (vo.getAltmnt_rm_cd() == 105) list5.add(vo);
            if (vo.getAltmnt_rm_cd() == 106) list6.add(vo);
            if (vo.getAltmnt_rm_cd() == 107) list7.add(vo);
            if (vo.getAltmnt_rm_cd() == 108) list8.add(vo);
            if (vo.getAltmnt_rm_cd() == 109) list9.add(vo);
            if (vo.getAltmnt_rm_cd() == 110) list10.add(vo);
        }
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
        model.addAttribute("list6", list6);
        model.addAttribute("list7", list7);
        model.addAttribute("list8", list8);
        model.addAttribute("list9", list9);
        model.addAttribute("list10", list10);
        return "AdminPageHtml/floor/A3F";
    }

    @RequestMapping(value = "/B1F")
    public String test9(Model model) {
        List<AdminVO> list = studentService.getUserRoom4();
        List<AdminVO> list1 = new ArrayList<>();
        List<AdminVO> list2 = new ArrayList<>();
        List<AdminVO> list3 = new ArrayList<>();
        List<AdminVO> list4 = new ArrayList<>();
        List<AdminVO> list5 = new ArrayList<>();
        List<AdminVO> list6 = new ArrayList<>();
        List<AdminVO> list7 = new ArrayList<>();
        List<AdminVO> list8 = new ArrayList<>();
        List<AdminVO> list9 = new ArrayList<>();
        List<AdminVO> list10 = new ArrayList<>();
        for (AdminVO vo : list) {
            if (vo.getAltmnt_rm_cd() == 101) list1.add(vo);
            if (vo.getAltmnt_rm_cd() == 102) list2.add(vo);
            if (vo.getAltmnt_rm_cd() == 103) list3.add(vo);
            if (vo.getAltmnt_rm_cd() == 104) list4.add(vo);
            if (vo.getAltmnt_rm_cd() == 105) list5.add(vo);
            if (vo.getAltmnt_rm_cd() == 106) list6.add(vo);
            if (vo.getAltmnt_rm_cd() == 107) list7.add(vo);
            if (vo.getAltmnt_rm_cd() == 108) list8.add(vo);
            if (vo.getAltmnt_rm_cd() == 109) list9.add(vo);
            if (vo.getAltmnt_rm_cd() == 110) list10.add(vo);
        }
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
        model.addAttribute("list6", list6);
        model.addAttribute("list7", list7);
        model.addAttribute("list8", list8);
        model.addAttribute("list9", list9);
        model.addAttribute("list10", list10);
        return "AdminPageHtml/floor/B1F";
    }

    @RequestMapping(value = "/B2F")
    public String test10(Model model) {
        List<AdminVO> list = studentService.getUserRoom5();
        List<AdminVO> list1 = new ArrayList<>();
        List<AdminVO> list2 = new ArrayList<>();
        List<AdminVO> list3 = new ArrayList<>();
        List<AdminVO> list4 = new ArrayList<>();
        List<AdminVO> list5 = new ArrayList<>();
        List<AdminVO> list6 = new ArrayList<>();
        List<AdminVO> list7 = new ArrayList<>();
        List<AdminVO> list8 = new ArrayList<>();
        List<AdminVO> list9 = new ArrayList<>();
        List<AdminVO> list10 = new ArrayList<>();
        for (AdminVO vo : list) {
            if (vo.getAltmnt_rm_cd() == 101) list1.add(vo);
            if (vo.getAltmnt_rm_cd() == 102) list2.add(vo);
            if (vo.getAltmnt_rm_cd() == 103) list3.add(vo);
            if (vo.getAltmnt_rm_cd() == 104) list4.add(vo);
            if (vo.getAltmnt_rm_cd() == 105) list5.add(vo);
            if (vo.getAltmnt_rm_cd() == 106) list6.add(vo);
            if (vo.getAltmnt_rm_cd() == 107) list7.add(vo);
            if (vo.getAltmnt_rm_cd() == 108) list8.add(vo);
            if (vo.getAltmnt_rm_cd() == 109) list9.add(vo);
            if (vo.getAltmnt_rm_cd() == 110) list10.add(vo);
        }
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
        model.addAttribute("list6", list6);
        model.addAttribute("list7", list7);
        model.addAttribute("list8", list8);
        model.addAttribute("list9", list9);
        model.addAttribute("list10", list10);
        return "AdminPageHtml/floor/B2F";
    }

    @RequestMapping(value = "/B3F")
    public String test11(Model model) {
        List<AdminVO> list = studentService.getUserRoom6();
        List<AdminVO> list1 = new ArrayList<>();
        List<AdminVO> list2 = new ArrayList<>();
        List<AdminVO> list3 = new ArrayList<>();
        List<AdminVO> list4 = new ArrayList<>();
        List<AdminVO> list5 = new ArrayList<>();
        List<AdminVO> list6 = new ArrayList<>();
        List<AdminVO> list7 = new ArrayList<>();
        List<AdminVO> list8 = new ArrayList<>();
        List<AdminVO> list9 = new ArrayList<>();
        List<AdminVO> list10 = new ArrayList<>();
        for (AdminVO vo : list) {
            if (vo.getAltmnt_rm_cd() == 101) list1.add(vo);
            if (vo.getAltmnt_rm_cd() == 102) list2.add(vo);
            if (vo.getAltmnt_rm_cd() == 103) list3.add(vo);
            if (vo.getAltmnt_rm_cd() == 104) list4.add(vo);
            if (vo.getAltmnt_rm_cd() == 105) list5.add(vo);
            if (vo.getAltmnt_rm_cd() == 106) list6.add(vo);
            if (vo.getAltmnt_rm_cd() == 107) list7.add(vo);
            if (vo.getAltmnt_rm_cd() == 108) list8.add(vo);
            if (vo.getAltmnt_rm_cd() == 109) list9.add(vo);
            if (vo.getAltmnt_rm_cd() == 110) list10.add(vo);
        }
        model.addAttribute("list1", list1);
        model.addAttribute("list2", list2);
        model.addAttribute("list3", list3);
        model.addAttribute("list4", list4);
        model.addAttribute("list5", list5);
        model.addAttribute("list6", list6);
        model.addAttribute("list7", list7);
        model.addAttribute("list8", list8);
        model.addAttribute("list9", list9);
        model.addAttribute("list10", list10);
        return "AdminPageHtml/floor/B3F";
    }



}

