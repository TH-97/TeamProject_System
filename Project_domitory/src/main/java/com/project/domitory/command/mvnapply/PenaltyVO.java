package com.project.domitory.command.mvnapply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PenaltyVO {
	private Integer rew_no;
	private Integer mvn_rcrt_no;
	private Integer stud_no;
	private String user_nm;
	private String rule_no;
	private Integer rew_scr;
	private String rew_date;
	private String rule_dtl;

	

}
