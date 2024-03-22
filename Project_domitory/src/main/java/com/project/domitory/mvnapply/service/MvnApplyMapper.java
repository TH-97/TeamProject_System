package com.project.domitory.mvnapply.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.domitory.command.EarDepApplicantVO;
import com.project.domitory.command.MVNApplicantVO;
import com.project.domitory.command.OBAndEarlyAllVO;
import com.project.domitory.command.OBApplicantVO;
import com.project.domitory.command.PenaltyVO;
import com.project.domitory.command.RuleVO;
import com.project.domitory.command.StudentVO1;

@Mapper
public interface MvnApplyMapper {
	List<MVNApplicantVO> getMvnList(MVNApplicantVO vo);
	List<EarDepApplicantVO> getEarlyList(EarDepApplicantVO vo);
	List<OBApplicantVO> getObList(OBApplicantVO vo);
	StudentVO1 getStudent(MVNApplicantVO vo);
	
	List<OBAndEarlyAllVO> getAllObEarlyList(OBAndEarlyAllVO vo);
	List<PenaltyVO> getPenaltyList(PenaltyVO vo);
	List<RuleVO> getRuleList();
	
	void applyFilterMen(Integer mvnRcrtNo);
	void applyFilterWomen(Integer mvnRcrtNo);
	
	void updateMvnEarly(MVNApplicantVO vo);
	void updateAltmntNope(MVNApplicantVO vo);
	void updateEarlyConfirm(EarDepApplicantVO vo);
	
	void updateOBConfirm(OBApplicantVO vo);
	
	void updatePenalty(@Param("studNo") Integer studNo, @Param("penalty") Integer penalty);
	void insertPenalty(PenaltyVO vo);
	
	
	
}
