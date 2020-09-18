package com.bbu.filter;
import com.bbu.setting.pojo.TblUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrmLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest)request;
        HttpServletResponse response1 = (HttpServletResponse) response;
//        request1.getRequestURI();两个相同表示全部路径
//        request1.getServletPath();
        String path = request1.getRequestURI();
        TblUser user_session = (TblUser)request1.getSession().getAttribute("USERSESSION");
        if (!path.contains("/User/login") &&
                !path.equals("/index.html") &&
                !path.equals("/login.html") &&
                !path.endsWith("js") &&
                !path.endsWith("css") &&
                !path.endsWith("JPG")){
            if(user_session != null){
                chain.doFilter(request1,response1);
            }
            else {
                //getContextPath()本地网络路径
                response1.sendRedirect(request1.getContextPath() + "/login.html");
            }
        }else {
            chain.doFilter(request1,response1);
        }
    }

    @Override
    public void destroy() {

    }
}

