package com.nuc.iblog.controler;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.service.MSUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/11 0:08
 * @Description :后台管理系统用户控制器
 */
@Controller
@RequestMapping("ms")
public class MSUserController {
    Logger log = LoggerFactory.getLogger(MSUserController.class);
    @Autowired
    MSUserService userService;

    /**
     * 显示用户列表
     * @param username
     * @return
     */
    @RequestMapping("admin-list")
    public ModelAndView adminList(String username) {
        log.info("用户查询条件：" + username);
        ModelAndView modelAndView = userService.adminList(username);

        return modelAndView;
    }

    /**
     * 修改密码视图
     * @param uid
     * @return
     */
    @RequestMapping("change-password")
    public ModelAndView changePassword(int uid) {
        ModelAndView modelAndView = userService.changePassword(uid);
        return modelAndView;
    }

    /**
     * 进行修改密码操作
     * @param user
     * @return
     */
    @RequestMapping("doChangePassword")
    @ResponseBody
    public Map<String,String> doChangePassword(User user) {
        log.info("修改密码请求，用户id：" + user.getUid() + "密码：" + user.getPassword());
        Map<String, String> map = userService.doChangePassword(user);
        return map;
    }

    /**
     * 进行用户权限修改
     * @param user
     * @return
     */
    @RequestMapping("doChangeAdmin")
    @ResponseBody
    public Map<String,String> doChangeAdmin(@RequestBody Map<String,String> user) {
        log.info("修改权限请求，用户id：" + user.get("uid"));
        Map<String, String> map = userService.doChangeAdmin(user);
        return map;
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping("deleteUser")
    @ResponseBody
    public Map<String,String> deleteUser(@RequestBody Map<String,String> user) {
        log.info("删除用户请求，用户id：" + user.get("uid"));
        Map<String, String> map = userService.deleteUser(user);
        return map;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping("addUser")
    @ResponseBody
    public Map<String,String> addUser(User user) {
        log.info("添加用户请求，用户id：" + user.getUsername());
        Map<String, String> map = userService.addUser(user);
        return map;
    }
}
