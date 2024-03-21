package com.project.domitory.Adminpage.service;

import com.project.domitory.Adminpage.mapper.StudentMapper;
import com.project.domitory.command.AdminVO;
import com.project.domitory.command.AutoVO;
import com.project.domitory.command.BuildingVO;
import com.project.domitory.command.FloorVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<AdminVO> getname(AdminVO vo) {
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
    public void reset(){
        List<AdminVO> list = studentMapper.getUserState();

        for(AdminVO vo : list){
            studentMapper.reset(String.valueOf(vo.getStud_no()));
        }
        List<AutoVO> list2 = studentMapper.getRm_cd();
        for (AutoVO vo :list2){
            studentMapper.reset2(vo.getRm_cd());
            System.out.println("들어오니?");
        }
    }

    @Override
    public List<AdminVO> getUserRoom() {
        return studentMapper.getUserRoom();
    }

    @Override
    public List<AdminVO> getUserRoom2() {
        return studentMapper.getUserRoom2();
    }

    @Override
    public List<AdminVO> getUserRoom3() {
        return studentMapper.getUserRoom3();
    }

    @Override
    public List<AdminVO> getUserRoom4() {
        return studentMapper.getUserRoom4();
    }

    @Override
    public List<AdminVO> getUserRoom5() {
        return studentMapper.getUserRoom5();
    }

    @Override
    public List<AdminVO> getUserRoom6() {
        return studentMapper.getUserRoom6();
    }


}
