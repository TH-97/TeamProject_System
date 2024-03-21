package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVO {
	private Integer stud_no;
	private String user_nm;
	private String gndr_nm;
	private Integer snths_scr;
	private Integer stud_gr;
	private String stud_pn;
	private Integer pn_pnt;
	private String mj;
	private String stud_ad;
	private Integer stud_dist;
}
