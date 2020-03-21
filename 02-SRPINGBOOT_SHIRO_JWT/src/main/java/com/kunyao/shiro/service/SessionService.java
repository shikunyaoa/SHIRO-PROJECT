package com.kunyao.shiro.service;

import com.kunyao.shiro.dto.UserOnline;

import java.util.List;

public interface SessionService {


    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
