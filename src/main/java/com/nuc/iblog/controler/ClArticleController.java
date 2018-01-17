package com.nuc.iblog.controler;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.entity.ArticlePage;
import com.nuc.iblog.entity.Comments;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.service.ClArticleService;
import com.nuc.iblog.service.ClCategoryService;
import com.nuc.iblog.service.ClUserBelongService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :文章相关
 */
@Controller
@RequestMapping("cl")
public class ClArticleController {
    Logger log = LoggerFactory.getLogger(ClArticleController.class);
    @Autowired
    private ClArticleService clArticleService;
    @Autowired
    private ClCategoryService clCategoryService;
    private Article article;
    private List<Comments> comments;
    private Map<String, Object> returnMap;

    @RequestMapping("/findArticle")
    public String findArticle(int aid, HttpServletRequest request) {
        log.info("用户查看id为:" + aid + "的文章");
        returnMap = new HashMap<String, Object>();
        article = clArticleService.getArticle(aid);
        comments = article.getComments();
        returnMap.put("Article", article);
        returnMap.put("Comments", comments);
        request.setAttribute("ArticleMap", returnMap);
        return "/cl/article";
    }

    private User user;
    private Page<Article> articlePage;
    @Autowired
    private ClUserBelongService clUserBelongService;
    @RequestMapping("/selfBlog")
    public String selfBlog(HttpServletRequest request, @RequestParam(defaultValue = "0") int pagenum) {
        user = (User) request.getSession().getAttribute("User");
        log.info("用户" + user.getUsername() + "查看个人博客");
        if(pagenum<0)
            pagenum=0;
        articlePage = clArticleService.getPageArticle(user.getUid(), pagenum);
        log.info(articlePage.getTotalPages()+"");
        request.setAttribute("Articles", articlePage.getContent());
        request.setAttribute("pagenums", articlePage.getTotalPages());
        request.setAttribute("pagenum", pagenum);
        request.setAttribute("Categories", clCategoryService.getAllCategory());
        request.setAttribute("UserBelongs",clUserBelongService.getUserBelongs(user.getUid()));
        return "/cl/selfblog";
    }

    @RequestMapping("/selfBlogCategory")
    public String selfBlogCateory(HttpServletRequest request, int catid) {
        user = (User) request.getSession().getAttribute("User");
        request.setAttribute("Articles", clArticleService.getArticleByUserAndCategory(user.getUid(), catid));
        request.setAttribute("Categories", clCategoryService.getAllCategory());
        return "cl/selfblog";
    }
    private ArticlePage articlePage1;
    @RequestMapping("/moreinfo")
    public String moinfo(HttpServletRequest request,int catid,@RequestParam(defaultValue = "0") int pagenum){
        if(pagenum<0)
            pagenum=0;
        log.info(catid+"");
        articlePage1 = clArticleService.getAcademyArticle(catid, pagenum);
        request.setAttribute("pagenums", articlePage1.getTotalpage());
        request.setAttribute("Category",clCategoryService.getCategory(catid));
        request.setAttribute("Info",articlePage1.getContent());
        request.setAttribute("pagenum",pagenum);
        return "cl/moreinfo";
    }
}
