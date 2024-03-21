package com.project.domitory.Adminpage.mapper;

import com.project.domitory.Adminpage.command.AutoVO;
import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.AdminVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {

    public List<AdminVO> getname(AdminVO vo);

    public List<BuildingVO> getBuliding(BuildingVO vo);

    public List<FloorVO> getFloor(FloorVO vo);


    public void setRoom(@Param("altmnt_rm_cd")String altmnt_rm_cd, @Param("stud_no")String stud_no);
    public void setRoom2(@Param("altmnt_rm_cd")String altmnt_rm_cd);

    public List<AutoVO> getUser();

    public AutoVO getGndr(int stud_no);

    public List<AutoVO> getRoom();

    public List<AdminVO> getUserRoom();

    public List<AdminVO> getUserRoom2();

    public List<AdminVO> getUserRoom3();

    public List<AdminVO> getUserRoom4();

    public List<AdminVO> getUserRoom5();

    public List<AdminVO> getUserRoom6();


}
