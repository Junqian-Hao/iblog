package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.UserBelong;
import com.nuc.iblog.jpa.UserBelongJpa;
import com.nuc.iblog.jpa.UserJpa;
import com.nuc.iblog.service.ClUserBelongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/16.
 *
 * @Description :
 */
@Service
public class ClUserBelongServiceImp implements ClUserBelongService {
    @Autowired
    private UserBelongJpa userBelongJpa;
    @Autowired
    private UserJpa userJpa;
    @Override
    public List<UserBelong> getUserBelongs(int uid) {
        return userBelongJpa.findUserBelongsByUser(userJpa.findByUid(uid));
    }
}
