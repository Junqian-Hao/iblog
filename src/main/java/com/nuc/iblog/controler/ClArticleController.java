package com.nuc.iblog.controler;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.entity.Comments;
import com.nuc.iblog.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @Description :
 */
@Controller
@RequestMapping("cl")
public class ClArticleController {
    Logger log = LoggerFactory.getLogger(ClArticleController.class);
    @Autowired
    private ArticleService articleService;
    private Article article;
    private List<Comments> comments;
    private Map<String,Object> returnMap;
    @RequestMapping("/findArticle")
    public String findArticle(@RequestParam int aid, HttpServletRequest request){
        log.info("用户查看id为:"+aid+"的文章");
        returnMap=new HashMap<String,Object>();
        article=articleService.getArticle(aid);
        comments=article.getComments();
        returnMap.put("Article",article);
        returnMap.put("Comments",comments);
        request.setAttribute("ArticleMap",returnMap);
        return "/cl/article";
    }
}
