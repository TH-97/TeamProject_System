package com.project.domitory.Adminpage.service;

import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.StudentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    public List<StudentVO> getname(StudentVO vo);
    public List<BuildingVO> getBuliding(BuildingVO vo);
    public List<FloorVO> getFloor(FloorVO vo);
    public void setRoom(@Param("altmnt_rm_cd") String altmnt_rm_cd, @Param("stud_no") String stud_no);

    public void setRoom2(@Param("altmnt_rm_cd") String altmnt_rm_cd);

    public void auto();
}
