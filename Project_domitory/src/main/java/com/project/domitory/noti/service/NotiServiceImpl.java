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
    public void delectNoti(String bbs_sn) {
        notiMapper.delectNoti(bbs_sn);
    }

    @Override
    public List<NotiVO> notiList() {
        return notiMapper.notiList();
    }
}
