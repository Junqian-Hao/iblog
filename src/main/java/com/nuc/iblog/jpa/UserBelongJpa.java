package com.nuc.iblog.jpa;


import com.nuc.iblog.entity.UserBelong;
import com.nuc.iblog.jpa.cl.ClUserBelongJpa;
import com.nuc.iblog.jpa.ms.MsUserBelongJpa;


/**
 * Created by Tyranitarx on 2018/1/16.
 *
 * @Description :
 */
public interface UserBelongJpa extends MsUserBelongJpa,ClUserBelongJpa,BaseJpa<UserBelong, Integer> {
}
