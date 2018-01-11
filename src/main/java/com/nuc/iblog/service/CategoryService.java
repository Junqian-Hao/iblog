package com.nuc.iblog.service;

import com.nuc.iblog.entity.Category;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
public interface CategoryService {
    @Transactional(rollbackFor = Exception.class)
    public List<Category> getAllCategory();
}
