package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.entity.UserBelong;
import com.nuc.iblog.jpa.CategoryJpa;
import com.nuc.iblog.jpa.UserBelongJpa;
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
            if(user.getPassword().equals(password)){
                return user;
            }
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
    @Autowired
    private UserBelongJpa userBelongJpa;
    @Autowired
    private CategoryJpa categoryJpa;
    @Override
    public int Regist(int catid,String username,String nickname, String password) {
        user=new User();
        UserBelong userBelong=new UserBelong();
        if(userJpa.findByUsername(username)!=null)
            return 0;
        else{
            user.setUsername(username);
            user.setPassword(password);
            user.setIsAdmin(0);
            user.setAcademyid(catid);
            user.setNickname(nickname);
            userJpa.save(user);
            userBelong.setUser(userJpa.findByUsername(username));
            userBelong.setCategory(categoryJpa.findByCatid(catid));
            userBelongJpa.save(userBelong);
            return 1;
        }
    }

    @Override
    public int change(int uid,String nickname, String originpassword, String inputpassword) {
            user=userJpa.findByUid(uid);
            if(!inputpassword.equals("")){
                if(originpassword.equals(user.getPassword())){
                    user.setPassword(inputpassword);
                    user.setNickname(nickname);
                    userJpa.save(user);
                    return 0;
                }else
                    return -1;
            }else {
                user.setNickname(nickname);
                userJpa.save(user);
            }
        return 1;
    }
}
