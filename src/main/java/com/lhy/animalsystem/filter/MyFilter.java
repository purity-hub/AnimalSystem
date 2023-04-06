package com.lhy.animalsystem.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*", filterName = "myFilter")
@Order(1)
public class MyFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //如果session中有用户信息，就放行
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //1.获取请求路径
        String requestURI = request.getRequestURI();
        //2.定义不需要登录就可以访问的路径
        String[] urls = {
                "/loginUser",
                "/",
                "/index",
                "/layui/**",
                "/static/favicon.ico",
                "/error"
        };
        //3.判断请求路径是否需要处理
        boolean check = check(urls, requestURI);
        if(check){
            //4.放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        //5.判断用户是否登录
        HttpSession session = request.getSession();
        Object user = session.getAttribute("loginUser");
        if(user != null){
            //6.放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}
