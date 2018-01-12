package com.nuc.iblog.controler;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.service.MSArticleService;
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
 * @Date 2018/1/12 14:48
 * @Description :
 */
@Controller
@RequestMapping("ms")
public class MSArticleController {
    @Autowired
    MSArticleService msArticleService;
    Logger log = LoggerFactory.getLogger(MSArticleController.class);

    @RequestMapping("article-list")
    public ModelAndView articleList(String key) {
        ModelAndView modelAndView = new ModelAndView("article-list");
        List<Article> select = msArticleService.select(key);
        modelAndView.addObject("articles", select);
        modelAndView.addObject("size", select.size());
        return modelAndView;
    }

    @RequestMapping("article-show")
    public ModelAndView articleShow(int aid) {
        log.info("请求博客查看页面" + aid);
        ModelAndView modelAndView = new ModelAndView("article-show");
        Article article = msArticleService.selectOne(aid);
        modelAndView.addObject("article", article);
        return modelAndView;
    }

    @RequestMapping("deleteArticle")
    @ResponseBody
    public Map<String, String> deleteArticle(@RequestBody Map<String, String> map) {
        log.info("删除博客" + map.get("aid"));
        Map<String, String> aid = msArticleService.delete(Integer.parseInt(map.get("aid")));
        return aid;
    }
}
