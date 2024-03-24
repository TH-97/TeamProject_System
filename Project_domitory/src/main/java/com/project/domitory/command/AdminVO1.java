package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //멤버변수를 받
@NoArgsConstructor  // 기본생성자
@Builder
public class AdminVO1 {

    private Integer stud_no;
    private String user_nm;
    private String altmnt_rm_cd;
    private Integer stts_clsf;
    private String gndr_nm;


}
