package com.nuc.iblog.service;

import com.nuc.iblog.entity.UserBelong;

import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/16.
 *
 * @Description :
 */

public interface ClUserBelongService {
    List<UserBelong> getUserBelongs(int uid);
}
