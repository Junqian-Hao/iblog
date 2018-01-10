package com.nuc.iblog.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * @Author hao
 * @Date 2018/1/9 13:09
 * @Description :项目jpa接口基类
 */
@NoRepositoryBean
public interface BaseJpa<T, ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>,Serializable{
}
