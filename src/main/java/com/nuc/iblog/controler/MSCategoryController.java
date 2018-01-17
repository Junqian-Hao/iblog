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

    /**
     * 查询所有学院
     *
     * @return
     */
    @RequestMapping("category-list")
    public ModelAndView categoryList() {
        ModelAndView modelAndView = new ModelAndView("category-list");
        List<Category> categories = msCategoryService.selectAllAcadem();
        modelAndView.addObject("categorys", categories);
        modelAndView.addObject("size", categories.size());
        return modelAndView;
    }

    /**
     * 查询团队
     *
     * @return
     */
    @RequestMapping("category-team-list")
    public ModelAndView categoryTeamList(String catid) {
        log.info("查询团队" + catid);
        ModelAndView modelAndView = new ModelAndView("category-team-list");
        List<Category> academy = msCategoryService.selectAllAcadem();
        if (catid == null || "".equals(catid)) {
            catid = String.valueOf(academy.get(0).getCatid());
            modelAndView.addObject("selected", academy.get(0).getCatid());
        } else {
            modelAndView.addObject("selected", Integer.parseInt(catid));
        }
        modelAndView.addObject("academy", academy);
        List<Category> categories = msCategoryService.selectAllTeam(Integer.parseInt(catid));
        modelAndView.addObject("categorys", categories);
        modelAndView.addObject("size", categories.size());
        return modelAndView;
    }

    /**
     * 添加团队页面
     * @return
     */
    @RequestMapping("category-team-add")
    public ModelAndView categoryTeamAdd() {
        log.info("添加团队页面");
        ModelAndView modelAndView = new ModelAndView("category-team-add");
        List<Category> academy = msCategoryService.selectAllAcadem();
        modelAndView.addObject("academy", academy);
        return modelAndView;
    }

    /**
     * 删除团队和学院
     *
     * @param mp
     * @return
     */
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

    /**
     * 添加团队
     * @param category 要添加的目标团队
     * @return 添加的结果 code 0 失败 1成功
     */
    @RequestMapping("addTeam")
    @ResponseBody
    public Map<String, String> addTeam(Category category) {
        log.info("添加团队：" + category.getName());
        Map<String, String> map = msCategoryService.addTeam(category);
        return map;
    }

    @RequestMapping("category-change")
    public ModelAndView categoryAdd(String catid) {
        ModelAndView modelAndView = new ModelAndView("category-change");
        log.info("修改学院页面");
        Category category = msCategoryService.selectByCatid(Integer.parseInt(catid));
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @RequestMapping("category-team-change")
    public ModelAndView categoryTeamChange(String catid) {
        ModelAndView modelAndView = new ModelAndView("category-team-change");
        log.info("修改团队页面");
        Category category = msCategoryService.selectByCatid(Integer.parseInt(catid));
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @RequestMapping("changeTeam")
    @ResponseBody
    public Map<String, String> changeTeam(Category category) {
        log.info("修改团队名称：" + category.getName());
        Map<String, String> map = msCategoryService.changeTeamName(category);
        return map;
    }
}
