package com.project.domitory.test;

import org.apache.ibatis.annotations.Mapper;

import com.project.domitory.command.AdminVO;
import com.project.domitory.command.StudentVO;
import com.project.domitory.command.UserVO;

@Mapper
public interface dummyMapper {

	public void dumy(Student vo);
	public int stud_join(StudentVO vo);
	public void admin_join(AdminVO vo);
	public void user_admin(UserVO vo);
	public void user_student(UserVO vo);
}
