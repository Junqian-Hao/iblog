package com.nuc.iblog.interceptor;

import com.nuc.iblog.controler.ClArticleController;
import com.nuc.iblog.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tyranitarx on 2018/1/13.
 *
 * @Description :
 */
public class ClLoginInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user=(User) httpServletRequest.getSession().getAttribute("User");
        log.info("访问的地址为:"+httpServletRequest.getRequestURI());
        if(!httpServletRequest.getRequestURI().contains("login")){
            if(user==null)
                httpServletResponse.sendRedirect("/cl/login");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
