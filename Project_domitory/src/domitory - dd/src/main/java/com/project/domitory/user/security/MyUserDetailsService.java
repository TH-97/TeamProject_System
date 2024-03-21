package com.project.domitory.user.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.domitory.user.command.StudentVO;
import com.project.domitory.user.command.UserVO;
import com.project.domitory.user.service.UserMapper;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserMapper userMapper;
	
	//로그인시도시 실행
	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {

		UserVO vo = userMapper.login(user_id);
		
		if(vo != null) {
			//최근 로그인 날짜 ,로그인시도 횟수 초기화 
			userMapper.loginCheck1(user_id);
			System.out.println("사용자정보 : " + vo);
			return new MyUserDetails(vo);
		}
		return null;
	}

}
