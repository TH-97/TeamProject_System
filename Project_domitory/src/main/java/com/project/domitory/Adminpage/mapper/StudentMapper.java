package com.project.domitory.Adminpage.mapper;

import com.project.domitory.Adminpage.command.AutoVO;
import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.StudentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Mapper
public interface StudentMapper {

    public List<StudentVO> getname(StudentVO vo);

    public List<BuildingVO> getBuliding(BuildingVO vo);

    public List<FloorVO> getFloor(FloorVO vo);


    public void setRoom(@Param("altmnt_rm_cd")String altmnt_rm_cd, @Param("stud_no")String stud_no);
    public void setRoom2(@Param("altmnt_rm_cd")String altmnt_rm_cd);

    public List<AutoVO> getUser();

    public AutoVO getGndr(int stud_no);

    public List<AutoVO> getRoom();



}
