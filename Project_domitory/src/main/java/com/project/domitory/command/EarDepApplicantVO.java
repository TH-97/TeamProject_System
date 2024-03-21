package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EarDepApplicantVO {
	private Integer ear_dep_no;
	private Integer mvn_rcrt_no;
	private Integer stud_no;
	private String ear_dep_rsn;
	private String aply_ymd;
	private String conf_ymd;
	private String rfnd_actno;
	private String rmrk;
	
	private String user_nm;
	
	private String altmnt_rm_cd;

}
