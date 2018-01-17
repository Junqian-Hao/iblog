package com.nuc.iblog.controler;

import com.nuc.iblog.service.ClArticleService;
import com.nuc.iblog.service.ClCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
@Controller
@RequestMapping("cl")
public class ClFirstPageController {
    Logger log = LoggerFactory.getLogger(ClFirstPageController.class);
    @Autowired
    private ClArticleService clArticleService;
    @Autowired
    private ClCategoryService clCategoryService;
    @RequestMapping("/firstpage")
    public String getFirstPage(HttpServletRequest request){
        log.info("用户进入首页");
        request.setAttribute("Categories",clCategoryService.getAllCategory());
        request.setAttribute("Articles", clArticleService.getArticles());
        request.setAttribute("AcademyArticles",clArticleService.getAllAcademyArticle());
        request.setAttribute("Academys",clCategoryService.getAllAcademy());
        return "/cl/firstpage";
    }

    @RequestMapping("/articleByCategory")
    public String articleByCategory(int catid,HttpServletRequest request){
        request.setAttribute("Articles",clArticleService.getArticlesByCategory(catid));
        request.setAttribute("Academys",clCategoryService.getAllAcademy());
        request.setAttribute("AcademyArticles",clArticleService.getAllAcademyArticle());
        return "/cl/firstpage";
    }

}
