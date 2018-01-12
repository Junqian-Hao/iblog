package com.nuc.iblog.service;

import com.nuc.iblog.entity.User;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 12:22
 * @Description : 后台管理系统的登录业务逻辑
 */
public interface MSLoginService {
    /**
     * 获取首页信息的业务逻辑
     * @param request
     * @return
     */
    ModelAndView index(HttpServletRequest request);

    /**
     * 进行登录操作的业务逻辑
     * @return
     */
    Map<String, String> doLogin(HttpServletRequest httpServletRequest,User user);

    /**
     * 退出操作的业务逻辑
     * @param httpServletRequest
     * @return
     */
    Map<String, String> exit(HttpServletRequest httpServletRequest);
}
