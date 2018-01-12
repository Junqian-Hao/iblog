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
    public List<Category> selectAll() {
        List<Category> all = categoryJpa.findAll();
        return all;
    }
}
