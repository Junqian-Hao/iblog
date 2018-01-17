package com.nuc.iblog.controler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nuc.iblog.entity.Category;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.CategoryJpa;
import com.nuc.iblog.service.ClCategoryService;
import com.nuc.iblog.service.ClUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tyranitarx on 2018/1/12.
 *
 * @Description :
 */
@Controller
@RequestMapping("cl")
public class CLUserController {
    Logger log = LoggerFactory.getLogger(CLUserController.class);
    @Autowired
    private ClCategoryService clCategoryService;
    @RequestMapping("/login")
    public String toPage(HttpServletRequest request){
        request.setAttribute("Academys",clCategoryService.getAllAcademy());
        return "/cl/login";
    }

    @Autowired
    private ClUserService clUserService;
    private User user;
    private Map<String,Object> returnMap;
    @ResponseBody
    @RequestMapping("/doLogin")
    public Map<String,Object> doLogin(@RequestBody String json, HttpServletRequest request){
        returnMap=new HashMap<String,Object>();
        JSONObject object=JSON.parseObject(json);
        log.info("用户登录获取到的json为:"+json);
        user= clUserService.Login(object.getString("username"),object.getString("password"));
        if(user!=null){
            request.getSession().setAttribute("User",user);
            returnMap.put("code","1");
            returnMap.put("msg","登录成功");
            return returnMap;
        }
        else
        {
            returnMap.put("code","0");
            returnMap.put("msg","用户名或密码错误");
            return returnMap;
        }
    }
    private int status;
    @ResponseBody
    @RequestMapping("/doRegist")
    public Map<String, Object> doRegist(@RequestBody String json,HttpServletRequest request){
        log.info("用户注册");
        returnMap=new HashMap<String,Object>();
        JSONObject object=JSON.parseObject(json);
        status= clUserService.Regist(object.getInteger("academy"),object.getString("username"),object.getString("nickname"),object.getString("password"));
        if(status==0){
                returnMap.put("code","0");
                returnMap.put("msg","用户名已存在");
                return returnMap;
        }else {
            returnMap.put("code","1");
            returnMap.put("msg","注册成功");
            return returnMap;
        }
    }
    @ResponseBody
    @RequestMapping("/changeSelf")
    public Map<String,Object> changeSelf(@RequestBody String json,HttpServletRequest request){
        returnMap=new HashMap<String,Object>();
        JSONObject object=JSON.parseObject(json);
        int uid=object.getInteger("uid");
        String nickname=object.getString("nickname");
        String originpassword=object.getString("originpassword");
        String inputpassword=object.getString("inputpassword");
        status=clUserService.change(uid,nickname,originpassword,inputpassword);
        user=(User)request.getSession().getAttribute("User");
        if(status==-1){
            returnMap.put("code","-1");
            return returnMap;
        }else if(status==0){
            returnMap.put("code","0");
            request.getSession().setAttribute("User",null);
            return returnMap;
        }else {
            returnMap.put("code","1");
            user.setNickname(nickname);
            request.getSession().setAttribute("User",user);
            return returnMap;
        }
    }
}
