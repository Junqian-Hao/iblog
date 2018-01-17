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
     * 添加学院
     * @param category
     * @return
     */
    Map<String, String> insertCategory(Category category);

    /**
     * 删除学院或团队
     * @param cid
     * @return
     */
    Map<String, String> deleteCategory(Integer cid);

    /**
     * 查询所有学院
     * @return
     */
    List<Category> selectAllAcadem();

    /**
     * 查询团队
     * @return
     */
    List<Category> selectAllTeam(int catid);

    /**
     * 通过catid查询学院或团队
     * @return
     */
    Category selectByCatid(int actid);

    /**
     * 修改团队名称
     * @param category
     * @return
     */
    Map<String, String> changeTeamName(Category category);

    /**
     * 添加团队
     * @param category
     * @return
     */
    Map<String, String> addTeam(Category category);

}
