package com.project.domitory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domitory.command.EarDepApplicantVO;
import com.project.domitory.command.OBApplicantVO;
import com.project.domitory.userapply.service.UserApplyService;

@Controller
@RequestMapping("/user")
public class UserApplyController {

	@Autowired
	@Qualifier("UserApply")
	private UserApplyService userApplyService;
	


	//입주신청서 작성페이지
	@GetMapping("/mvnApply")
	public String mvnApply(Model model, Authentication authentication) {
		// 나중에 세션값 받아서 처리 필요
		// 학번
		String userNo = authentication.getName();
		System.out.println(userNo);
		model.addAttribute("userVO", userApplyService.getStudent(userNo));
		System.out.println(userApplyService.getStudent(userNo));
		return "user/apply/mvn_aply";
	}

	@PostMapping("/mvnInsert")
	public String mvnInsert(@RequestParam("MVN_RCRT_NO") String rcrtNo, @RequestParam("distance") int distance,
			Model model ) {
		// 나중에 세션값 받아서 처리 필요
		// 학번
		String studNo = authentication.getName();
		if(userApplyService.getIsMvnApply(studNo) == 0) {
			userApplyService.insertMvnApply(studNo, rcrtNo);
			userApplyService.updateDistance(studNo, distance);
		}else {
			model.addAttribute("msg", "중복 신청 불가");
		}
			
		return "user/apply/userMain";

	}
	
	//퇴실신청서 작성페이지
	@GetMapping("/earlyApply")
	public String earlyApply(Model model) {
		String userNo = "4171404";
		model.addAttribute("userVO", userApplyService.getStudent(userNo));
		return "user/apply/early_aply";
	}
	
	@PostMapping("/earlyInsert")
	public String earlyInsert(EarDepApplicantVO vo, Model model) {
		System.out.println(vo);
		//3번이상 작성하면 신청못하게 처리 필요함
		//if( 조회 >= 3)
		
		userApplyService.insertEarDepApply(vo);
		model.addAttribute("msg", "신청 완료");
		return "user/apply/userMain";
	}
	
	//외박신청서 작성페이지
	@GetMapping("/obApply")
	public String obApply(Model model) {
		String userNo = "4171409";
		model.addAttribute("userVO", userApplyService.getStudent(userNo));
		return "user/apply/ob_aply";
	}
	
	@PostMapping("/obInsert")
	public String obInsert(OBApplicantVO vo, Model model) {
		System.out.println(vo);
	
		vo.setBgng_ymd(vo.getBgng_ymd().replace("-", ""));
		vo.setEnd_ymd(vo.getEnd_ymd().replace("-", ""));
		userApplyService.insertObApply(vo);
		model.addAttribute("msg", "신청 완료");
		
		return "user/apply/userMain";
	}
	

}
