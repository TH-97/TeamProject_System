package com.project.domitory.mvnapply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domitory.command.EarDepApplicantVO;
import com.project.domitory.command.MVNApplicantVO;
import com.project.domitory.command.OBAndEarlyAllVO;
import com.project.domitory.command.OBApplicantVO;
import com.project.domitory.command.PenaltyVO;
import com.project.domitory.command.RuleVO;
import com.project.domitory.command.StudentVO;

@Service
public class MvnApplyServiceImpl implements MvnApplyService{
	@Autowired
	private MvnApplyMapper applyMapper;

	@Override
	public List<MVNApplicantVO> getMvnList(MVNApplicantVO vo) {
		return applyMapper.getMvnList(vo);
	}

	@Override
	public StudentVO getStudent(MVNApplicantVO vo) {
		return applyMapper.getStudent(vo);
	}


	@Override
	public List<EarDepApplicantVO> getEarlyList(EarDepApplicantVO vo) {
		return applyMapper.getEarlyList(vo);
	}

	@Override
	public List<OBApplicantVO> getObList(OBApplicantVO vo) {
		return applyMapper.getObList(vo);
	}

	@Override
	public void updateMvnEarly(MVNApplicantVO vo) {
		applyMapper.updateMvnEarly(vo);
		
	}

	@Override
	public void updateEarlyConfirm(EarDepApplicantVO vo) {
		applyMapper.updateEarlyConfirm(vo);
		
	}

	@Override
	public void updateOBConfirm(OBApplicantVO vo) {
		applyMapper.updateOBConfirm(vo);
		
	}

	@Override
	public void applyFilterMen(Integer mvnRcrtNo) {
		applyMapper.applyFilterMen(mvnRcrtNo);
		
	}

	@Override
	public void applyFilterWomen(Integer mvnRcrtNo) {
		applyMapper.applyFilterWomen(mvnRcrtNo);
	}

	@Override
	public void updateAltmntNope(MVNApplicantVO vo) {
		applyMapper.updateAltmntNope(vo);
		
	}

	@Override
	public List<OBAndEarlyAllVO> getAllObEarlyList(OBAndEarlyAllVO vo) {
		return applyMapper.getAllObEarlyList(vo);
	}

	@Override
	public List<PenaltyVO> getPenaltyList(PenaltyVO vo) {
		return applyMapper.getPenaltyList(vo);
	}

	@Override
	public List<RuleVO> getRuleList() {
		return applyMapper.getRuleList();
	}

	@Override
	public void updatePenalty(Integer studNo, Integer penalty) {
		applyMapper.updatePenalty(studNo, penalty);
		
	}

	@Override
	public void insertPenalty(PenaltyVO vo) {
		applyMapper.insertPenalty(vo);
		
	}
}
