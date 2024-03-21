package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MVNApplicantVO {
	private Integer MVN_RCRT_NO;
	private Integer STUD_NO;
	private String ALTMNT_RM_CD;
	private String STTS_CLSF;
	private String APLY_YMD;
	private String CONF_YMD;
	private String ALTMNT_YMD;
	private String MVN_YMD;
	private String DEP_YMD;
	private String DEP_CLSF;
	private Integer REW_TSCR;
	private String RMRK;
	
	private String USER_NM;
	private String PN_PNT;
	
}
