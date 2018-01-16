package com.nuc.iblog.service;

import com.nuc.iblog.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tyranitarx on 2018/1/12.
 *
 * @Description :
 */
public interface ClUserService {
    @Transactional(rollbackFor = Exception.class)
    User Login(String username, String password);

    @Transactional(rollbackFor = Exception.class)
    int Regist(int catid,String username,String nickname, String password);
}
