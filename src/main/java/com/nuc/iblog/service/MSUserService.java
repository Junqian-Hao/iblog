package com.nuc.iblog.service;

import com.nuc.iblog.entity.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 12:41
 * @Description : 后台管理系统的用户管理业务逻辑
 */
public interface MSUserService {
    ModelAndView adminList(String username);

    ModelAndView changePassword(int uid);

    Map<String, String> doChangePassword(User user);

    Map<String, String> doChangeAdmin(Map<String, String> user);

    public Map<String, String> deleteUser(Map<String, String> user);

    public Map<String, String> addUser(User user);
}
