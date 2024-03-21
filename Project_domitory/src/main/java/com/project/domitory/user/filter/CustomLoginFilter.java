package com.project.domitory.user.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.domitory.user.security.MyUserDetails;

public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {

	//UsernamePasswordAuthenticationFilter는 로그인을 담당하는 필터 
	//사용자 로그인을 여러분 커스터마이징 시키려면 상속받고, 연결해주면 됩니다.
	
	private AuthenticationManager authenticationManager;
	
	public CustomLoginFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	
	// post방식의  /login 요청이 들어오면, attemptAuthentication로 연결됩니다.
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		System.out.println("attemptAuthentication 필터 실행됨");
		
		//JSON타입이라면, request JSON데이터를 꺼내서, 사용할 수 있도록 파싱........
		
		String user_id = request.getParameter("user_id"); //폼방식의 데이터
		String user_pw = request.getParameter("user_pw");
		
		System.out.println(user_id);
		
		//UsernamePasswordAuthon - (JSON웹토큰 아님)
		//이 값을 인증매니저 AuthonticationManager에게 전달
		UsernamePasswordAuthenticationToken token =
				new UsernamePasswordAuthenticationToken(user_id, user_pw);
		
		//유저 서비스의 loadbyUser가 호출이 됩니다.
		Authentication authentication = authenticationManager.authenticate(token); 
		//로그인 실패시 이값은 null
		System.out.println("필터: 로그인이 성공하면 이값이 있습니다:" + authentication); 
			
		
		return authentication; //스프링 시큐리티가 이값을 가져가서, 시큐리티 세션에 등록을 시킴
	}


	//로그인 성공시에는 이 메서드가 실행됨
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		System.out.println("로그인 success후에 실행됨");
		
		MyUserDetails details = (MyUserDetails)authResult.getPrincipal(); 
		System.out.println(details.getAuthorities());
		
		
		
	}
	//로그인 실패시에는 이 메서드가 실행됨
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		System.out.println("로그인 실패시 실행됨");
		//클라이언트로 에러를 보내줌
//		response.setContentType("text/plain; charset=UTF8");
//		response.sendError(500, "아이디 비밀번호를 확인하세요");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
