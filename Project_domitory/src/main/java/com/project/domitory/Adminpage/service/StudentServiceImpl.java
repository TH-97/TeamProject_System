package com.project.domitory.Adminpage.service;

import com.project.domitory.Adminpage.command.AutoVO;
import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.StudentVO;
import com.project.domitory.Adminpage.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentVO> getname(StudentVO vo) {
        return studentMapper.getname(vo);
    }

    @Override
    public List<BuildingVO> getBuliding(BuildingVO vo) {
        return studentMapper.getBuliding(vo);
    }

    @Override
    public List<FloorVO> getFloor(FloorVO vo) {
        return studentMapper.getFloor(vo);
    }

    @Override
    public void setRoom(String altmnt_rm_cd, String stud_no) {
        studentMapper.setRoom(altmnt_rm_cd,stud_no);
    }

    @Override
    public void setRoom2(String altmnt_rm_cd) {
        studentMapper.setRoom2(altmnt_rm_cd);
    }

    @Override
    public void auto() {
      List<AutoVO> userList = studentMapper.getUser();

      for(int i = 0; i < userList.size(); i++){
          AutoVO userListVO = userList.get(i);

          int stud_no = userListVO.getStud_no();


          AutoVO gndr = studentMapper.getGndr(stud_no);
          if(Objects.equals(gndr.getGndr_nm(), "M")){

              List<AutoVO> roomList = studentMapper.getRoom();
              for(AutoVO list : roomList){

//                  System.out.println(list.getRm_cd() + " " + list.getUsg_clsf() + " " + list.getUse_yn() + " " +list.getAltmnt_nope() );

                  if(Objects.equals(list.getUsg_clsf(),"1") &&
                    Objects.equals(list.getUse_yn(), "1") &&
                          list.getAltmnt_nope() < 2){
                      System.out.println("들어왔니?");

                      String altmnt_rm_cd = list.getRm_cd();
                      System.out.println(stud_no);
                      System.out.println(altmnt_rm_cd);
                      studentMapper.setRoom(altmnt_rm_cd, String.valueOf(stud_no));
                      studentMapper.setRoom2(altmnt_rm_cd);
                      return;

                  } else if (list.getAltmnt_nope() == 2) {
                      continue;
                  }
              }
          }
      }


    }

    @Override
    public List<StudentVO> getUserRoom() {
        return studentMapper.getUserRoom();
    }

    @Override
    public List<StudentVO> getUserRoom2() {
        return studentMapper.getUserRoom2();
    }

    @Override
    public List<StudentVO> getUserRoom3() {
        return studentMapper.getUserRoom3();
    }

    @Override
    public List<StudentVO> getUserRoom4() {
        return studentMapper.getUserRoom4();
    }

    @Override
    public List<StudentVO> getUserRoom5() {
        return studentMapper.getUserRoom5();
    }

    @Override
    public List<StudentVO> getUserRoom6() {
        return studentMapper.getUserRoom6();
    }


}