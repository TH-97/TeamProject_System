package com.project.domitory.Adminpage.mapper;

import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

    public List<StudentVO> getname(StudentVO vo);

    public List<BuildingVO> getBuliding(BuildingVO vo);

    public List<FloorVO> getFloor(FloorVO vo);


}
