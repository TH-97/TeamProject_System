package com.project.domitory.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //멤버변수를 받
@NoArgsConstructor  // 기본생성자
@Builder
public class NotiVO {

    private String bbs_nm;
    private String bbs_cn;
    //삭제를 위한
    private Integer bbs_sn;
    //select을 위한
    private String bbs_reg_ymd;

}
