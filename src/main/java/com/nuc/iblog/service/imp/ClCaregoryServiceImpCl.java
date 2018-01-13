package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.Category;
import com.nuc.iblog.jpa.CategoryJpa;
import com.nuc.iblog.service.ClCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
@Service
public class ClCaregoryServiceImpCl implements ClCategoryService {
    @Autowired
    private CategoryJpa categoryJpa;
    public List<Category> getAllCategory(){
        return categoryJpa.findAll();
    }
}
