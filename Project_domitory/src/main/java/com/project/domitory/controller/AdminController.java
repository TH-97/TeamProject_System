package com.project.domitory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class AdminController {


//	@Autowired
//	private UserMapper userMapper;
//	@Autowired
//	private BCryptPasswordEncoder bCryptpasswordEncoder;
	
	@GetMapping("/")
	public String admin_main() {
		return "admin";
	}
	
	@GetMapping("/find_pw")
	public String find_pw() {
		return "admin/find_pw";
	}
}
