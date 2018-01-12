package com.nuc.iblog.controler;

import com.nuc.iblog.entity.Category;
import com.nuc.iblog.service.MSCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 13:50
 * @Description : 后台管理系统分类管理控制器
 */
@Controller
@RequestMapping("ms")
public class MSCategoryController {
    @Autowired
    MSCategoryService msCategoryService;
    Logger log = LoggerFactory.getLogger(MSCategoryController.class);

    @RequestMapping("category-list")
    public ModelAndView categoryList() {
        ModelAndView modelAndView = new ModelAndView("category-list");
        List<Category> categories = msCategoryService.selectAll();
        modelAndView.addObject("categorys", categories);
        modelAndView.addObject("size", categories.size());
        return modelAndView;
    }

    @RequestMapping("deleteCategory")
    @ResponseBody
    public Map<String, String> deleteCategory(@RequestBody Map<String, String> mp) {
        log.info("删除分类" + mp.get("cid"));
        Map<String, String> map = msCategoryService.deleteCategory(Integer.valueOf(mp.get("cid")));
        return map;
    }

    @RequestMapping("addCategory")
    @ResponseBody
    public Map<String, String> addCategory(Category category) {
        log.info("添加分类：" + category.getName());
        Map<String, String> map = msCategoryService.insertCategory(category);
        return map;
    }
}
