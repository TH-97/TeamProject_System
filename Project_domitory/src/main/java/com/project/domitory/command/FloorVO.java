package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //멤버변수를 받
@NoArgsConstructor  // 기본생성자
@Builder
public class FloorVO {
    private String rm_cd;
    private String bldg_cd;
    private String actc_nope;
    private String altmnt_nope;
}

