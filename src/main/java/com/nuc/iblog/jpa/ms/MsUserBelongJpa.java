package com.nuc.iblog.jpa.ms;

import com.nuc.iblog.entity.UserBelong;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Tyranitarx on 2018/1/16.
 *
 * @Description :
 */
@NoRepositoryBean
public interface MsUserBelongJpa extends BaseJpa<UserBelong, Integer> {
}
