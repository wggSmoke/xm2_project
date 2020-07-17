package com.igeek.core;



import com.igeek.redis.RedisUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;




public class MySession implements HttpSession {
    RedisUtil redisUtil=new RedisUtil();

    private String sessionId;
    private  int MaxInactiveInterval=60*60;
    public MySession(String sessionId) {
        this.sessionId=sessionId;

    }

    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return this.sessionId;
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int i) {
        this.MaxInactiveInterval=i;
    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return  redisUtil.hget(sessionId,s);
    }

    @Override
    public Object getValue(String s) {
        return null;
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        return null;
    }

    @Override
    public String[] getValueNames() {
        return new String[0];
    }

    @Override
    public void setAttribute(String s, Object o) {
        redisUtil.hset(sessionId,s,o,MaxInactiveInterval);
    }

    @Override
    public void putValue(String s, Object o) {

    }

    @Override
    public void removeAttribute(String s) {
        redisUtil.hdel(sessionId,s);
    }
    public void removeAttribute(String... s) {
        redisUtil.hdel(sessionId,s);
    }

    @Override
    public void removeValue(String s) {

    }

    @Override
    public void invalidate() {
        redisUtil.del(sessionId);
    }

    @Override
    public boolean isNew() {
        return false;
    }
}
