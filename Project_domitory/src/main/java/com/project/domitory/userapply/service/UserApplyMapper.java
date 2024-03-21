package com.project.domitory.userapply.service;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.domitory.command.mvnapply.EarDepApplicantVO;
import com.project.domitory.command.mvnapply.OBApplicantVO;
import com.project.domitory.command.mvnapply.StudentVO;

@Mapper
public interface UserApplyMapper {
	public StudentVO getStudent(String studNo);
	int getIsMvnApply(String studNo);
	public int updateDistance(@Param("studNo") String studNo, @Param("distance") int distance);
	public int insertMvnApply(@Param("studNo") String studNo, @Param("rcrtNo") String rcrtNo);
	
	public void insertEarDepApply(EarDepApplicantVO vo);
	public void insertObApply(OBApplicantVO vo);
}
