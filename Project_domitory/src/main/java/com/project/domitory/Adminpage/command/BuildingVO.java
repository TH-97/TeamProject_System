package com.project.domitory.Adminpage.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //멤버변수를 받
@NoArgsConstructor  // 기본생성자
@Builder
public class BuildingVO {
    private String bldg_cd;
    private String bldg_nm;
    private Integer flr_qty;
    private String rmrk;
}

