package com.project.domitory.command.mvnapply;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OBAndEarlyAllVO {
	private Integer mvn_rcrt_no;
	private Integer stud_no;
	private String user_nm;
	private String aply_ymd;
	private String apply;
	
}
