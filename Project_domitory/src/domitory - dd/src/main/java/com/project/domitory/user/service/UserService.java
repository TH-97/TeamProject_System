package com.project.domitory.user.service;


import com.project.domitory.user.command.AdminVO;
import com.project.domitory.user.command.StudentVO;
import com.project.domitory.user.command.UserVO;


public interface UserService {

	public void stud_join(StudentVO vo);
	public void admin_join(AdminVO vo);
	public void user_admin(UserVO vo);
	public void user_student(UserVO vo);
	public UserVO login(String user_id);
	void loginCheck(String user_id);
	public int update(StudentVO vo);
	public void dumy(Student vo);
}
