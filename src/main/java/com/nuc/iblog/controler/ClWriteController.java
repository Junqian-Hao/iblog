package com.nuc.iblog.controler;


import com.nuc.iblog.service.ArticleService;
import com.nuc.iblog.service.CategoryService;
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
public class ClWriteController {
    Logger log = LoggerFactory.getLogger(ClWriteController.class);
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/writeArticle")
    public String toWritePage(HttpServletRequest request){
        request.setAttribute("Categories",categoryService.getAllCategory());
        return "/cl/write";
    }

    @RequestMapping("/writeSubmit")
    public String WriteAndtoSelfBlog(String title,int catid,String summary,String content){
        log.info("catid");
        articleService.InsertArticle(1,catid,title,summary,content);
        return "/cl/selfblog";
    }
}
