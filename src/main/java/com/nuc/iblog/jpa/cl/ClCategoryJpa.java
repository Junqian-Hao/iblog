package com.nuc.iblog.jpa.cl;

import com.nuc.iblog.entity.Category;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/10 11:50
 * @Description :
 */
@NoRepositoryBean
public interface ClCategoryJpa extends BaseJpa<Category,Integer> {
    Category findByCatid(int catid);
    Category findCategoryByName(String catname);
    List<Category> findCategoryByCategoryEqualsOrderByCatidAsc(Category category);
}
