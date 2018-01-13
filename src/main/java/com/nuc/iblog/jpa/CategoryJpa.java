package com.nuc.iblog.jpa;


import com.nuc.iblog.entity.Category;
import com.nuc.iblog.jpa.cl.ClCategoryJpa;
import com.nuc.iblog.jpa.ms.MsCategoryJpa;

/**
 * @Author hao
 * @Date 2018/1/9 13:26
 * @Description :文章分类jpa接口
 */
public interface CategoryJpa extends MsCategoryJpa,ClCategoryJpa, BaseJpa<Category, Integer> {
}
