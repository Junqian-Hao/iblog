package com.nuc.iblog.controler;

import com.nuc.iblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
@Controller
@RequestMapping("cl")
public class ClSelfArticleController {
    @Autowired
    private ArticleService articleService;
    @RequestMapping("/selfBlog")
    public String selfBlog(@RequestParam int uid, HttpServletRequest request){
        request.setAttribute("Articles",articleService.getArticlesByUser(uid));
        return "/cl/selfblog";
    }
}
