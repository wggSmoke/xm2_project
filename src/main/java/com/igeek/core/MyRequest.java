package com.igeek.core;

import javax.servlet.http.*;
import java.util.UUID;

public class MyRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public MyRequest(HttpServletRequest request, HttpServletResponse response) {
        super(request);
        this.request = request;
        this.response=response;
    }

    @Override
    public HttpSession getSession() {
        Cookie[] cookie=request.getCookies();
        String sessionId=null;
        //便利
        if(cookie!=null){
            for (Cookie cookie1 : cookie) {
                if(cookie1.getName().equals("MySessionId")){
                    //将原本cook中的值转到session中
                    sessionId=cookie1.getValue();
                    break;
                }
            }
        }
        //没有cookie
        if (sessionId==null){
            sessionId= UUID.randomUUID().toString();
            Cookie cookies=new Cookie("MySessionId",sessionId);
            response.addCookie(cookies);
        }

        MySession Session=new MySession(sessionId);

    return Session;
    }
}
