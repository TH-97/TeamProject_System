package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //멤버변수를 받
@NoArgsConstructor  // 기본생성자
@Builder
public class AutoVO {
    //학생의 성별을 구분하기 위해 학번을 가져와서 select
    private Integer stud_no;

    //상태구분을 하기위해 값을 가져온다
    private String stts_clsf;
    //젠터 값 가져오기
    private String gndr_nm;


    //호실정보
    private String rm_cd;
    private String bldg_cd;
    private String flr_clsf;
    private String rm_nm;
    private String usg_clsf;
    private String gndr_clsf;
    private Integer actc_nope;
    private String use_yn;
    //지금까지 배정된 인원
    private Integer altmnt_nope;
}
