package com.project.domitory.userapply.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.domitory.command.EarDepApplicantVO;
import com.project.domitory.command.OBApplicantVO;
import com.project.domitory.command.StudentVO;

@Service("UserApply")
public class UserApplyServiceImpl implements UserApplyService {
	
	@Autowired
	private UserApplyMapper userApplyMapper;
	//입주신청
	//////////////////////////////////////
	//학번으로 학생테이블 조회
	@Override
	public StudentVO getStudent(String studNo) {
		return userApplyMapper.getStudent(studNo);
	}
	
	//이미 신청했는지 조회
	@Override
	public int getIsMvnApply(String studNo) {
		return userApplyMapper.getIsMvnApply(studNo);
	}
	
	
	//학번PK로 mvn_aply테이블에 입주신청 insert
	@Override
	public int insertMvnApply(String studNo, String rcrtNo) {
		return userApplyMapper.insertMvnApply(studNo, rcrtNo);
	}

	//학생주소부터 학교까지의 거리 학생테이블에 update
	@Override
	public int updateDistance(String studNo, int distance) {	
		return userApplyMapper.updateDistance(studNo, distance);
	}
	
	//퇴실신청
	/////////////////////////////////////
	//학번PK로 ear_dep_aply테이블에 퇴실신청 insert
	@Override
	public void insertEarDepApply(EarDepApplicantVO vo) {
		userApplyMapper.insertEarDepApply(vo);
	}

	@Override
	public void insertObApply(OBApplicantVO vo) {
		userApplyMapper.insertObApply(vo);
		
	}
	




}
