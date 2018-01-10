package com.nuc.iblog.jpa.cl;


import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author hao
 * @Date 2018/1/9 13:27
 * @Description : 用户jpa接口
 */
@NoRepositoryBean
public interface ClUserJpa extends BaseJpa<User,Integer> {
}
