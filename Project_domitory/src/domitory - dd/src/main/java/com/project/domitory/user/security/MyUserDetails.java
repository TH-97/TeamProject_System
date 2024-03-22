package com.project.domitory.user.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.domitory.user.command.UserVO;
import com.project.domitory.user.service.UserMapper;

public class MyUserDetails implements UserDetails{

	private UserVO userVO;
	
	public MyUserDetails(UserVO userVO) {
		this.userVO = userVO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> list = new ArrayList<>();
		
		list.add( () -> userVO.getRole() );
		
		
		
		return list;
	}
	public String getRole() {
		return userVO.getRole();
	}

	@Override
	public String getPassword() {
		return userVO.getUser_pw();
	}

	@Override
	public String getUsername() {
		return String.valueOf(userVO.getUser_id());
	}

	@Override
	public boolean isAccountNonExpired() { // 휴먼계정
		//마지막 접속일 부터 3개월
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { //로그인 시도 횟수
		boolean bool ;
		if(userVO.getLogin_tc()>3) {
			bool = false;
		}else {
			bool = true;
		}
		//3회 이상 실패시
		return bool;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호 변경 주기
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() { //회원탈퇴
		boolean bool ;
		if(userVO.getLogin_ena().equals("T")) {
			bool = true;
		}else {
			bool = false;
		}
		
		return bool;
	}


	
}
