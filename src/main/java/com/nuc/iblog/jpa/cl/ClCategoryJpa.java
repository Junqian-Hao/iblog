package com.nuc.iblog.jpa.cl;

import com.nuc.iblog.entity.Category;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author hao
 * @Date 2018/1/10 11:50
 * @Description :
 */
@NoRepositoryBean
public interface ClCategoryJpa extends BaseJpa<Category,Integer> {
    Category findCategoryByName(String catname);
}
