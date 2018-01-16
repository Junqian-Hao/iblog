package com.nuc.iblog.jpa.cl;

import com.nuc.iblog.entity.User;
import com.nuc.iblog.entity.UserBelong;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/16.
 *
 * @Description :
 */
@NoRepositoryBean
public interface ClUserBelongJpa extends BaseJpa<UserBelong, Integer> {
    List<UserBelong> findUserBelongsByUser(User user);
}
