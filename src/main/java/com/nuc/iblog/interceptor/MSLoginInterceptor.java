package com.nuc.iblog.interceptor;

import com.nuc.iblog.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author hao
 * @Date 2018/1/15 11:16
 * @Description : 后台管理系统拦截器
 */
public class MSLoginInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(MSLoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user=(User) httpServletRequest.getSession().getAttribute("userlogin");
        String requestURI = httpServletRequest.getRequestURI();
        log.info("访问的地址为:"+requestURI);
        if(!requestURI.contains("ogin")&&!requestURI.contains("Kaptcha")){
            if(user==null)
                httpServletResponse.sendRedirect("/ms/login");
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
