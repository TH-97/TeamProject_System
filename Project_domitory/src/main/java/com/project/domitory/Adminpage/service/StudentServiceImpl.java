package com.project.domitory.Adminpage.service;

import com.project.domitory.Adminpage.command.BuildingVO;
import com.project.domitory.Adminpage.command.FloorVO;
import com.project.domitory.Adminpage.command.StudentVO;
import com.project.domitory.Adminpage.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
