package com.nuc.iblog.jpa.ms;


import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/9 13:27
 * @Description : 用户jpa接口
 */
@NoRepositoryBean
public interface MsUserJpa extends BaseJpa<User, Integer> {
    User findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * FROM user a WHERE a.username LIKE CONCAT('%',:username,'%')", nativeQuery = true)
    List<User> findByUserNameLimit(@Param("username") String keyName);


}
