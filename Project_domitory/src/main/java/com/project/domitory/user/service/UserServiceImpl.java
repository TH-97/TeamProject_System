package com.project.domitory.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.domitory.command.AdminVO;
import com.project.domitory.command.StudentVO;
import com.project.domitory.command.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper ;


	@Override
	public UserVO login(String user_id) {
		return userMapper.login(user_id);
	}

	@Override
	public void loginCheck(String user_id) {
		userMapper.loginCheck2(user_id);
		
	}



	@Override
	public int update(StudentVO vo) {
		int a = userMapper.update(vo);
		
		
		
		return a;
	}

	@Override
	public void stud_join(StudentVO vo) {
		
		userMapper.stud_join(vo);
		
	}

	@Override
	public void admin_join(AdminVO vo) {
		userMapper.admin_join(vo);
	}

	@Override
	public void user_admin(UserVO vo) {
		System.out.println("service");
		userMapper.user_admin(vo);
	}

	@Override
	public void user_student(UserVO vo) {
		userMapper.user_student(vo);
	}

	



	
}
