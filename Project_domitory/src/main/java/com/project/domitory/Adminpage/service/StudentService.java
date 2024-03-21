package com.project.domitory.Adminpage.service;

import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.AdminVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    public List<AdminVO> getname(AdminVO vo);
    public List<BuildingVO> getBuliding(BuildingVO vo);
    public List<FloorVO> getFloor(FloorVO vo);
    public void setRoom(@Param("altmnt_rm_cd") String altmnt_rm_cd, @Param("stud_no") String stud_no);

    public void setRoom2(@Param("altmnt_rm_cd") String altmnt_rm_cd);

    public void auto();

    public List<AdminVO> getUserRoom();

    public List<AdminVO> getUserRoom2();

    public List<AdminVO> getUserRoom3();

    public List<AdminVO> getUserRoom4();

    public List<AdminVO> getUserRoom5();

    public List<AdminVO> getUserRoom6();
}
