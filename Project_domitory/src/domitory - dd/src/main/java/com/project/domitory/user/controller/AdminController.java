package com.project.domitory.user.controller;

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
	
	@GetMapping("/admin_main")
	public String admin_main() {
		return "admin/admin_main";
	}
	
	@GetMapping("/find_pw")
	public String find_pw() {
		return "admin/find_pw";
	}
}
