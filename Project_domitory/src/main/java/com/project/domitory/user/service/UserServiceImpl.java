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

	@Override
	public void dumy(Student vo) {
		if(vo.getRole().equals("ROLE_ADMIN")) {
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			String pw =(bc.encode(vo.getPassword()));
			AdminVO vo1 = new AdminVO();
			vo1.setAdmin_no(vo.getStud_no());
			vo1.setAdmin_nm(vo.getFullName());
			vo1.setAdmin_pn(String.valueOf(vo.getStud_pn()));
			vo1.setRole(vo.getRole());
			vo1.setAdmin_pw(pw);
			userMapper.admin_join(vo1);
			
			UserVO userVO = new UserVO();
			userVO.setUser_id(vo1.getAdmin_no());
			userVO.setAdmin_no(vo1.getAdmin_no());
			userVO.setRole(vo1.getRole());
			userVO.setUser_pw(pw);
			//userVO에도 넣기
			userMapper.user_admin(userVO);
		}else if (vo.getRole().equals("ROLE_STUDENT")){
			BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
			String pw =(bc.encode(vo.getPassword()));
			
			StudentVO vo2 = new StudentVO();
			
			vo2.setMj(vo.getMj());
			vo2.setRole(vo.getRole());
			vo2.setStud_no(vo.getStud_no());
			vo2.setStud_pw(pw);
			vo2.setStud_pn(String.valueOf(vo.getStud_pn()));
			
			userMapper.stud_join(vo2);
			
			UserVO userVO = new UserVO();
			userVO.setUser_id(vo.getStud_no());
			userVO.setUser_pw(pw);
			userVO.setRole(vo.getRole());
			userVO.setStud_no(vo.getStud_no());
			//userVO에도 넣기
			userMapper.user_student(userVO);
		}
	}



	
}
