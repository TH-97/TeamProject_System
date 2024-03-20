package com.project.domitory.Adminpage.controller;

import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;

import com.project.domitory.Adminpage.command.StudentVO;
import com.project.domitory.Adminpage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class AdminPageController {

    @Autowired
    @Qualifier("StudentServiceImpl")
    //컨트롤러의 다음 흐름은 바로 service이기때문에 @Qualifier를 이용하여 지정해서 바로가져온다
    private StudentService studentService;


    @GetMapping("/")
    public String adminPage(){

        return "AdminPageHtml/adminMainPage";
    }
    @PostMapping("/selectStudent")
    public String test(@RequestParam("name") String name , Model model){
        StudentVO vo = new StudentVO();
        //파라미터로 값을 기져와서 이름을 vo에 저장한다
        vo.setUser_nm(name);
        //db에서 가져온 list를 list에 저장한다
        List<StudentVO> list = studentService.getname(vo);
        //model에 list라는 이름으로 저장한다
        model.addAttribute("list", list);
        return "AdminPageHtml/roomAssignment";
    }
    @RequestMapping("/buildingFloor")
    public String test2(@RequestParam("gndr_nm") String gndr_nm,Model model){
        BuildingVO vo = new BuildingVO();
        if(gndr_nm.equals("M")) {
            vo.setBldg_nm("남자관");
        } else vo.setBldg_nm("여자관");
        List<BuildingVO> list = studentService.getBuliding(vo);
        model.addAttribute("list",list);
        return "AdminPageHtml/buildingFloor";
    }
    @RequestMapping("room")
    public String test3(@RequestParam("bldg_cd")String bldg_cd,Model model){
        FloorVO vo = new FloorVO();
        vo.setBldg_cd(bldg_cd);
        List<FloorVO> list = studentService.getFloor(vo);
        model.addAttribute("list",list);
        return "AdminPageHtml/room";
    }
    @PostMapping("/modify")
    public String test4(@RequestParam("stud_no")String stud_no,
                        @RequestParam("name")String name,
                        @RequestParam("altmnt_rm_cd")String altmnt_rm_cd
    ){
        studentService.setRoom(altmnt_rm_cd,stud_no);
        studentService.setRoom2(altmnt_rm_cd);
        return "AdminPageHtml/room";
    }

    @PostMapping("/test")
    public String test5(){
        studentService.auto();
        return "AdminPageHtml/roomAssignment";
    }

}

