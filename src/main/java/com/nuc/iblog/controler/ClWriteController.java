package com.nuc.iblog.controler;


import com.nuc.iblog.entity.User;
import com.nuc.iblog.service.ClArticleService;
import com.nuc.iblog.service.ClCategoryService;
import com.nuc.iblog.util.SensitiveWordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :文章增删改
 */
@Controller
@RequestMapping("cl")
public class ClWriteController {
    Logger log = LoggerFactory.getLogger(ClWriteController.class);
    @Autowired
    private ClArticleService clArticleService;
    @Autowired
    private ClCategoryService clCategoryService;
    @RequestMapping("/writeArticle")
    public String toWritePage(HttpServletRequest request){
        log.info("用户"+request.getSession().getAttribute("user")+"写博客");
        request.setAttribute("Categories", clCategoryService.getAllCategory());
        return "/cl/write";
    }
    private User user;
    private Set<String> sensitiveWordLib;
    @RequestMapping("/writeSubmit")
    public String WriteAndtoSelfBlog(String title,String catname,String content,HttpServletRequest request) {
        sensitiveWordLib=(Set<String>) request.getSession().getServletContext().getAttribute("sensitiveWordLib");
        if(sensitiveWordLib==null)
            SensitiveWordUtil.init(SensitiveWordUtil.getSensitiveWordLib());
        else
            SensitiveWordUtil.init(sensitiveWordLib);
        content = SensitiveWordUtil.replaceSensitiveWord(content, '*', SensitiveWordUtil.MinMatchTYpe);
        log.info("catid" + catname);
        user=(User)request.getSession().getAttribute("User");
        clArticleService.InsertArticle(user.getUid(),
                catname, title, "111", content);

        return "/cl/selfblog";
    }
    @RequestMapping("/updateArticle")
    public String toUpdatePage(HttpServletRequest request,int aid){
        sensitiveWordLib=(Set<String>) request.getSession().getServletContext().getAttribute("sensitiveWordLib");
        if(sensitiveWordLib==null)
            SensitiveWordUtil.init(SensitiveWordUtil.getSensitiveWordLib());
        else
            SensitiveWordUtil.init(sensitiveWordLib);
        request.setAttribute("Categories", clCategoryService.getAllCategory());
        request.setAttribute("Article", clArticleService.getArticle(aid));
        return "/cl/write";
    }
}
