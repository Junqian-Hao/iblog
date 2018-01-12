package com.nuc.iblog.service;

import com.nuc.iblog.entity.Category;

import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 13:53
 * @Description : 博客分类后台管理系统业务逻辑
 */
public interface MSCategoryService {
    /**
     * 添加分类
     * @param category
     * @return
     */
    Map<String, String> insertCategory(Category category);

    /**
     * 删除分类
     * @param cid
     * @return
     */
    Map<String, String> deleteCategory(Integer cid);

    /**
     * 查询所有分类
     * @return
     */
    List<Category> selectAll();
}
