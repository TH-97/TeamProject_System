package com.project.domitory.Adminpage.service;

import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.StudentVO;

import java.util.List;

public interface StudentService {
    public List<StudentVO> getname(StudentVO vo);
    public List<BuildingVO> getBuliding(BuildingVO vo);
    public List<FloorVO> getFloor(FloorVO vo);
}
