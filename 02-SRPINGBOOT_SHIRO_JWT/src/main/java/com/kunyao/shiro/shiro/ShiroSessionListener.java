package com.kunyao.shiro.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: ShiroSessionListener
 * @Author: kunyao
 * @Description:  维护着一个原子类，用于统计在Session的数量
 * @Date: 2020/3/21 10:57
 * @Version: 1.0
 */
public class ShiroSessionListener implements SessionListener {
    private final AtomicInteger sessionCount = new AtomicInteger(0);

    @Override
    public void onStart(Session session) {
        sessionCount.incrementAndGet();
    }

    @Override
    public void onStop(Session session) {
        sessionCount.decrementAndGet();
    }

    @Override
    public void onExpiration(Session session) {
        sessionCount.decrementAndGet();
    }


}