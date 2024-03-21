package com.project.domitory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.domitory.command.EarDepApplicantVO;
import com.project.domitory.command.MVNApplicantVO;
import com.project.domitory.command.OBAndEarlyAllVO;
import com.project.domitory.command.OBApplicantVO;
import com.project.domitory.command.PenaltyVO;
import com.project.domitory.command.StudentVO;
import com.project.domitory.mvnapply.service.MvnApplyService;

@Controller
public class MvnApplyController {

	@Autowired
	private MvnApplyService applyService;

	@GetMapping("/admin")
	public String adminMain() {
		return "mvn/adminMainPage";
	}

	@GetMapping("/mvnAplySelect")
	public String mvnAplySelect(MVNApplicantVO vo, Model model) {

		System.out.println(vo);
		model.addAttribute("list", applyService.getMvnList(vo));
		System.out.println(applyService.getMvnList(vo));
		model.addAttribute("search", vo);

		return "mvn/mvnAplySelect";
	}

	@GetMapping("/mvnAplySelectDetail")
	public String mvnAplySelectDetail(MVNApplicantVO vo, Model model) {

		System.out.println(vo);
		model.addAttribute("mvndetailVO", applyService.getMvnList(vo));
		model.addAttribute("studentVO", applyService.getStudent(vo));
		model.addAttribute("search", vo);

		return "mvn/mvnselectDetail";
	}

	@GetMapping("/detail")
	public String detail(MVNApplicantVO vo, Model model) {
		List<MVNApplicantVO> vo2 = new ArrayList<>();
		vo2.add(vo);
		model.addAttribute("mvndetailVO", vo2);

		return "mvn/mvnselectDetail";
	}

	// 필터링
	@GetMapping("/mvnAplyFilter")
	public String mvnAplyFilter(@RequestParam("mvn_rcrt_no") Integer mvnRcrtNo, RedirectAttributes rs) {
		applyService.applyFilterMen(mvnRcrtNo);
		applyService.applyFilterWomen(mvnRcrtNo);
		rs.addAttribute("msg", "필터링 완료");
		return "mvn/mvnAplySelect";
	}

	// 외박, 퇴실 페이지 1차 조회
	@GetMapping("/obAndEarlySelect")
	public String obAndEarlySelect(OBAndEarlyAllVO vo, Model model) {
		System.out.println(vo);
		model.addAttribute("list", applyService.getAllObEarlyList(vo));
		System.out.println(applyService.getAllObEarlyList(vo));
		model.addAttribute("search", vo);

		return "mvn/obAndEarlyConfirm";
	}

	// 퇴실 2차 조회
	@GetMapping("/earlySelectDatil")
	public String earlySelectDatil(EarDepApplicantVO vo, Model model) {
		System.out.println(vo);
		// 조회
		model.addAttribute("EarList", applyService.getEarlyList(vo));
		System.out.println(applyService.getEarlyList(vo));

		return "mvn/earlySelect";
	}

	// 퇴실 승인처리
	@PostMapping("/updateEarly")
	public String updateEarly(MVNApplicantVO mvnvo, EarDepApplicantVO earvo, Model model) {
		System.out.println(mvnvo);
		System.out.println(earvo);
		// 입주자 퇴실처리
		applyService.updateMvnEarly(mvnvo);
		// 입주자 입주호실 -1하기
		applyService.updateAltmntNope(mvnvo);
		// 외박신청 승인처리
		applyService.updateEarlyConfirm(earvo);

		earvo.setMvn_rcrt_no(mvnvo.getMVN_RCRT_NO());
		earvo.setStud_no(mvnvo.getSTUD_NO());
		model.addAttribute("EarList", applyService.getEarlyList(earvo));

		return "mvn/earlySelect";
	}

	// 외박 2차 조회
	@GetMapping("/obSelectDatil")
	public String obSelectDatil(OBApplicantVO vo, Model model) {
		System.out.println(vo);
		// 신청조회
		model.addAttribute("OBList", applyService.getObList(vo));
		System.out.println(applyService.getObList(vo));

		return "mvn/obAplySelect";
	}

	// 외박 승인처리
	@PostMapping("/updateOB")
	public String updateOB(OBApplicantVO vo, Model model) {
		System.out.println(vo);

		// 승인 처리
		applyService.updateOBConfirm(vo);

		model.addAttribute("OBList", applyService.getObList(vo));

		return "mvn/obAplySelect";
	}

	// 벌점 1차조회
	@GetMapping("/penaltySelect")
	public String penaltySelect(MVNApplicantVO vo, Model model) {
		System.out.println(vo);
		model.addAttribute("list", applyService.getMvnList(vo));
		System.out.println(applyService.getMvnList(vo));
		model.addAttribute("ruleVO", applyService.getRuleList());
		model.addAttribute("search", vo);

		return "mvn/penaltySelect";
	}

	// 벌점 2차 상세조회
	@GetMapping("/penaltyDetail")
	public String penaltyDetail(PenaltyVO vo, Model model) {
		System.out.println(vo);
		model.addAttribute("penalVO", applyService.getPenaltyList(vo));
		System.out.println(applyService.getPenaltyList(vo));
		model.addAttribute("search", vo);

		return "mvn/penaltyDetail";
	}
	
	@PostMapping("/penaltyUpdate")
	public String penaltyUpdate( PenaltyVO penvo,
								
								@RequestParam("pnPnt") Integer penalty, Model model) {
		System.out.println("뿡입니다."+penalty);
		
		applyService.updatePenalty(penvo.getStud_no(), penalty);
		applyService.insertPenalty(penvo);
		MVNApplicantVO mvnvo = new MVNApplicantVO();
		mvnvo.setSTUD_NO(penvo.getStud_no());
		mvnvo.setMVN_RCRT_NO(penvo.getMvn_rcrt_no());
		model.addAttribute("list", applyService.getMvnList(mvnvo));
		model.addAttribute("ruleVO", applyService.getRuleList());
		return "mvn/penaltySelect";
	}

}
