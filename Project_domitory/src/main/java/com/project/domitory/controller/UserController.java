package com.project.domitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domitory.command.AdminVO;
import com.project.domitory.command.StudentVO;
import com.project.domitory.command.UserVO;
import com.project.domitory.user.service.UserMapper;
import com.project.domitory.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private BCryptPasswordEncoder bCryptpasswordEncoder;

	@Autowired
	@Qualifier("userService")
	private UserService userService ;

	
	@GetMapping("/mainPage")
	public String student_main() {
		return "mainPage";
	}
	

	@GetMapping("/user_join")
	public String join() {
		return "user/user_join";
	}

	@PostMapping("/joinForm")
	public String joinForm(StudentVO vo, RedirectAttributes ra) {


		String pw = bCryptpasswordEncoder.encode(vo.getStud_pw());
		System.out.println(vo);
		vo.setStud_pw(pw);


		//서비스 구현
		if(vo.getRole().equals("ROLE_ADMIN")) {
			AdminVO vo1 = new AdminVO();
			vo1.setAdmin_no(vo.getStud_no());
			vo1.setAdmin_nm(vo.getUser_nm());
			vo1.setAdmin_pn(vo.getStud_pn());
			vo1.setRole(vo.getRole());
			vo1.setAdmin_pw(pw);
			userService.admin_join(vo1);
			
			UserVO userVO = new UserVO();
			userVO.setUser_id(vo1.getAdmin_no());
			userVO.setAdmin_no(vo1.getAdmin_no());
			userVO.setRole(vo1.getRole());
			userVO.setUser_pw(pw);
			//userVO에도 넣기
			userService.user_admin(userVO);
			ra.addFlashAttribute("msg", "관리자 계정 추가 완료 ");
		}else if (vo.getRole().equals("ROLE_STUDENT")){
			userService.stud_join(vo);
			
			UserVO userVO = new UserVO();
			userVO.setUser_id(vo.getStud_no());
			userVO.setUser_pw(pw);
			userVO.setRole(vo.getRole());
			userVO.setStud_no(vo.getStud_no());
			//userVO에도 넣기
			userService.user_student(userVO);
			ra.addFlashAttribute("msg", "학생 회원가입 완료");
		}


		return "redirect:/user/user_join";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "err", required= false)String err 
						,Model model){

		System.out.println(err);
		if(err != null) {
			model.addAttribute("msg" , "아이디와 비밀번호를 확인해주세요");
		}

		
		return "user/login";

	}

	@GetMapping("/userDetail")
	public String userDetail() {
		return "user/userDetail";
	}


	@GetMapping("/user_main")
	public String userMain() {
		return "user/user_main";
	}

	@GetMapping("/user_deny")
	public String deny() {
		return "user/user_deny";
	}

	@GetMapping("/user_findID")
	public String find_id() {
		return "user/user_findID";
	}

	@GetMapping("/user_findPW")
	public String find_pw() {
		return "user/user_findPW";
	}
	@GetMapping("/user_findPW_result")
	public String find_pw_result() {
		return "user/user_findPW_result";
	}
	@PostMapping("/updateForm")
	public String updateForm(StudentVO vo,
			RedirectAttributes ra) {
		String pw = bCryptpasswordEncoder.encode(vo.getStud_pw());
		vo.setStud_pw(pw);
		
		int result = userService.update(vo);

		if(result == 1) {
			ra.addFlashAttribute("msg", "수정 완료되었습니다");
		} else {
			ra.addFlashAttribute("msg", "수정에 실패했습니다");
		}


		return "redirect:/user/myPage";
	}
//
//	@GetMapping("/myPage")
//	public String update(@RequestParam(value =  ,required= false)String err , Model model) {
//		
//	}

	@GetMapping("/user_update")
	public String update() {
		return "user/user_update";
	}
	@GetMapping("/delete")
	public String delete(UserVO vo) {
		
		return "user/user_login";
	}
}

