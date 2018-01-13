package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.UserJpa;
import com.nuc.iblog.service.ClUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2018/1/12.
 *
 * @Description :
 */
@Service
public class ClClUserServiceImp implements ClUserService {
    @Autowired
    private UserJpa userJpa;
    private User user;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User Login(String username, String password) {
        user=userJpa.findByUsername(username);
        if(user==null){
            return null;
        }
        else {
            if(user.getPassword().equals(password))
                return user;
            else
                return null;
        }
    }

    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    @Override
    public int Regist(String username, String password) {
        user=new User();
        if(userJpa.findByUsername(username)!=null)
            return 0;
        else{
            user.setUsername(username);
            user.setPassword(password);
            userJpa.save(user);
            return 1;
        }
    }
}
