package com.project.domitory.user.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {
	private Integer user_id;
	private String user_pw;
	private String role;
	private Integer stud_no;
	private Integer admin_no;
	private String login_date;
	private String login_ena;
	private Integer login_tc;
	
}
