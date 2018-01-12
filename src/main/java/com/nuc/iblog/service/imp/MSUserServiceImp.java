package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.UserJpa;
import com.nuc.iblog.service.MSUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 12:48
 * @Description :
 */
@Service
public class MSUserServiceImp implements MSUserService {
    @Autowired
    UserJpa userJpa;
    @Override
    public ModelAndView adminList(String username) {
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

    @Override
    public ModelAndView changePassword(int uid) {
        ModelAndView modelAndView = new ModelAndView("change-password");
        User byUid = userJpa.findOne(uid);
        modelAndView.addObject("user", byUid);
        return modelAndView;
    }

    @Override
    public Map<String, String> doChangePassword(User user) {
        HashMap<String, String> map = new HashMap<String, String>();
        User byUid = userJpa.findOne(user.getUid());
        byUid.setPassword(user.getPassword());
        userJpa.save(byUid);
        map.put("code","1");
        return map;
    }

    @Override
    public Map<String, String> doChangeAdmin(Map<String, String> user) {
        HashMap<String, String> map = new HashMap<String, String>();
        User byUid = userJpa.findOne(Integer.valueOf(user.get("uid")));
        Integer isAdmin = byUid.getIsAdmin();
        if (isAdmin == 0) {
            byUid.setIsAdmin(1);
        } else {
            byUid.setIsAdmin(0);
        }
        userJpa.save(byUid);
        map.put("code","1");
        return map;
    }

    @Override
    public Map<String, String> deleteUser(Map<String, String> user) {
        HashMap<String, String> map = new HashMap<String, String>();
        userJpa.delete(Integer.valueOf(user.get("uid")));
        map.put("code","1");
        return map;
    }

    @Override
    public Map<String, String> addUser(User user) {
        User byUsername = userJpa.findByUsername(user.getUsername());
        HashMap<String, String> map = new HashMap<String, String>();
        if (byUsername != null) {
            map.put("code", "0");
            return map;
        }
        userJpa.save(user);
        map.put("code","1");
        return map;
    }
}
