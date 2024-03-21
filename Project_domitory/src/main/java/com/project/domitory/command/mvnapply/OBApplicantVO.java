package com.project.domitory.command.mvnapply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OBApplicantVO {
	private Integer ob_no;
	private Integer mvn_rcrt_no;
	private Integer stud_no;
	private String bgng_ymd;
	private String end_ymd;
	private String ob_rsn;
	private String aply_ymd;
	private String conf_ymd;
	private String rmrk;

	private String user_nm;
}
