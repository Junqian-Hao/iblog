package com.nuc.iblog.jpa.ms;

import com.nuc.iblog.entity.Category;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author hao
 * @Date 2018/1/10 11:50
 * @Description :
 */
@NoRepositoryBean
public interface MsCategoryJpa extends BaseJpa<Category,Integer> {
    Category findByName(String name);
}
