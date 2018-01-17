package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.Category;
import com.nuc.iblog.jpa.CategoryJpa;
import com.nuc.iblog.service.MSCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 13:57
 * @Description : 分类管理的业务实现
 */
@Service
public class MSCategoryServiceImp implements MSCategoryService {
    @Autowired
    CategoryJpa categoryJpa;

    @Override
    public Map<String, String> insertCategory(Category category) {
        HashMap<String, String> map = new HashMap<String, String>();
        Category byName = categoryJpa.findByName(category.getName());
        //类别已存在
        if (byName != null) {
            map.put("code", "0");
            return map;
        }
        Category save = categoryJpa.save(category);
        if (save != null) {
            map.put("code", "1");
        } else {
            map.put("code", "0");
        }
        return map;
    }

    @Override
    public Map<String, String> deleteCategory(Integer cid) {
        HashMap<String, String> map = new HashMap<String, String>();
        categoryJpa.delete(cid);
        map.put("code", "1");
        return map;
    }

    @Override
    public List<Category> selectAllAcadem() {
        List<Category> all = categoryJpa.findByCategoryOrderByCatid(null);
        return all;
    }

    @Override
    public List<Category> selectAllTeam(int catid) {
        Category one = categoryJpa.findOne(catid);
        List<Category> byCategory = categoryJpa.findByCategoryOrderByCatid(one);
        return byCategory;
    }

    @Override
    public Category selectByCatid(int actid) {
        Category one = categoryJpa.findOne(actid);
        return one;
    }

    @Override
    public Map<String, String> changeTeamName(Category category) {
        HashMap<String, String> map = new HashMap<String, String>();
        Category one = categoryJpa.findOne(category.getCatid());
        Category byNameAndCategory = categoryJpa.findByNameAndCategory(category.getName(), one.getCategory());
        if (byNameAndCategory != null) {
            map.put("code", "0");
            return map;
        }
        one.setName(category.getName());
        Category save = categoryJpa.save(one);
        if (save != null) {
            map.put("code", "1");
        } else {
            map.put("code", "0");
        }
        return map;
    }

    @Override
    public Map<String, String> addTeam(Category category) {
        HashMap<String, String> map = new HashMap<String, String>();
        Category one = categoryJpa.findOne(category.getCatid());
        Category category1 = new Category();
        category1.setName(category.getName());
        category1.setCategory(one);
        categoryJpa.save(category1);
        map.put("code", "1");
        return map;
    }
}
