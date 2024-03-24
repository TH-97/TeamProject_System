package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminVO {

	
	private Integer admin_no;
	private String admin_nm;
	private String role;
	private String admin_pn;
	private String admin_pw;

}
