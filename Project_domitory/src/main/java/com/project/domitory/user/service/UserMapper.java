package com.project.domitory.user.service;

import org.apache.ibatis.annotations.Mapper;

import com.project.domitory.command.AdminVO;
import com.project.domitory.command.StudentVO;
import com.project.domitory.command.UserVO;

@Mapper
public interface UserMapper {
	public void stud_join(StudentVO vo);
	public void admin_join(AdminVO vo);
	public void user_admin(UserVO vo);
	public void user_student(UserVO vo);
	public UserVO login(String user_id);
	public void loginCheck1(String user_id);
	public void loginCheck2(String user_id);
	public int update(StudentVO vo);
	
	
}
