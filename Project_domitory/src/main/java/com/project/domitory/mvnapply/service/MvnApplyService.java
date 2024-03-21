package com.project.domitory.mvnapply.service;

import java.util.List;

import com.project.domitory.command.mvnapply.EarDepApplicantVO;
import com.project.domitory.command.mvnapply.MVNApplicantVO;
import com.project.domitory.command.mvnapply.OBAndEarlyAllVO;
import com.project.domitory.command.mvnapply.OBApplicantVO;
import com.project.domitory.command.mvnapply.PenaltyVO;
import com.project.domitory.command.mvnapply.RuleVO;
import com.project.domitory.command.mvnapply.StudentVO;

public interface MvnApplyService {
	List<MVNApplicantVO> getMvnList(MVNApplicantVO vo);
	List<EarDepApplicantVO> getEarlyList(EarDepApplicantVO vo);
	List<OBApplicantVO> getObList(OBApplicantVO vo);
	StudentVO getStudent(MVNApplicantVO vo);
	void applyFilterMen(Integer mvnRcrtNo);
	void applyFilterWomen(Integer mvnRcrtNo);
	
	List<OBAndEarlyAllVO> getAllObEarlyList(OBAndEarlyAllVO vo);
	List<PenaltyVO> getPenaltyList(PenaltyVO vo);
	List<RuleVO> getRuleList();
	
	void updateMvnEarly(MVNApplicantVO vo);
	void updateAltmntNope(MVNApplicantVO vo);
	void updateEarlyConfirm(EarDepApplicantVO vo);
	
	void updateOBConfirm(OBApplicantVO vo);
	
	void updatePenalty(Integer studNo, Integer penalty);
	void insertPenalty(PenaltyVO vo);
}
