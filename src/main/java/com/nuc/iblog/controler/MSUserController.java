package com.nuc.iblog.controler;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.UserJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
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
    UserJpa userJpa;

    @RequestMapping("admin-list")
    public ModelAndView adminList(String username) {
        log.info("用户查询条件：" + username);
        ModelAndView modelAndView = new ModelAndView("admin-list");
        List<User> all = null;
        if (username == null || "".equals(username)) {
            all = userJpa.findAll();
        } else {
           all = userJpa.findByUserNameLimit(username);
        }
        modelAndView.addObject("users", all);
        modelAndView.addObject("size", all.size());
        return modelAndView;
    }

    @RequestMapping("change-password")
    public ModelAndView changePassword(int uid) {
        ModelAndView modelAndView = new ModelAndView("change-password");
        User byUid = userJpa.findOne(uid);
        modelAndView.addObject("user", byUid);
        return modelAndView;
    }

    @RequestMapping("doChangePassword")
    @ResponseBody
    public Map<String,String> doChangePassword(User user) {
        log.info("修改密码请求，用户id：" + user.getUid() + "密码：" + user.getPassword());
        HashMap<String, String> map = new HashMap<String, String>();
        User byUid = userJpa.findOne(user.getUid());
        byUid.setPassword(user.getPassword());
        userJpa.save(byUid);
        map.put("code","0");
        return map;
    }
    @RequestMapping("doChangeAdmin")
    @ResponseBody
    public Map<String,String> doChangeAdmin(@RequestBody Map<String,String> user) {
        log.info("修改权限请求，用户id：" + user.get("uid"));
        HashMap<String, String> map = new HashMap<String, String>();
        User byUid = userJpa.findOne(Integer.valueOf(user.get("uid")));
        Integer isAdmin = byUid.getIsAdmin();
        if (isAdmin == 0) {
            byUid.setIsAdmin(1);
        } else {
            byUid.setIsAdmin(0);
        }
        userJpa.save(byUid);
        map.put("code","0");
        return map;
    }
    @RequestMapping("deleteUser")
    @ResponseBody
    public Map<String,String> deleteUser(@RequestBody Map<String,String> user) {
        log.info("删除用户请求，用户id：" + user.get("uid"));
        HashMap<String, String> map = new HashMap<String, String>();
        userJpa.delete(Integer.valueOf(user.get("uid")));
        map.put("code","0");
        return map;
    }
}
