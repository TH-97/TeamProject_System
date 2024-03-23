package com.project.domitory.noti.service;

import com.project.domitory.command.NotiVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotiServiceImpl implements NotiService{

    @Autowired
    private NotiMapper notiMapper;
    @Override
    public void addNoti(String bbs_nm, String bbs_cn) {
        notiMapper.addNoti(bbs_nm,bbs_cn);
    }

    @Override
    public void delectNoti(int bbs_sn) {
        notiMapper.delectNoti(bbs_sn);
    }

    @Override
    public List<NotiVO> notiList() {
        return notiMapper.notiList();
    }

    @Override
    public List<NotiVO> songList() {
        return notiMapper.songList();
    }

    @Override
    public void deletSong(Integer song_no) {
        notiMapper.deletSong(song_no);
    }

    @Override
    public void addSong(String stud_no,String title) {
        notiMapper.addSong(stud_no,title);
    }
}
