package com.project.domitory.noti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotiServiceImpl implements NotiService{

    @Autowired
    private NotiMapper notiMapper;
    @Override
    public void addNoti() {
        notiMapper.addNoti();
    }
}
