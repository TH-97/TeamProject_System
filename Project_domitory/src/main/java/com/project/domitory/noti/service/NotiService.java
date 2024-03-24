package com.project.domitory.noti.service;

import com.project.domitory.command.NotiVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NotiService {
    public void addNoti(@Param("bbs_nm")String bbs_nm,@Param("bbs_cn")String bbs_cn);

    public void delectNoti(@Param("bbs_sn")Integer bbs_sn);

    public List<NotiVO> notiList();

    public List<NotiVO> songList();

    public void deletSong(@Param("song_no")Integer song_no);

    public void addSong(@Param("stud_no")String stud_no,@Param("title")String title);
}
