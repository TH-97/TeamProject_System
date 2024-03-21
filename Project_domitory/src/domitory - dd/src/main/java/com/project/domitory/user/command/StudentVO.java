package com.project.domitory.user.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentVO {

	private Integer stud_no;
	private String stud_pw;
	private String user_nm;
	private String role;
	private String gndr_nm;
	private float snths_scr;
	private Integer stud_gr;
	private String stud_pn;
	private Integer pn_pnt;
	private String mj;
	private String stud_ad;
	private Integer stud_dist;
}
