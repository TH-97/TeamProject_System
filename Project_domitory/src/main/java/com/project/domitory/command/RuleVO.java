package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleVO {
	private String rule_no;
	private String rule_dtl;
	private Integer rew_scr;
}
