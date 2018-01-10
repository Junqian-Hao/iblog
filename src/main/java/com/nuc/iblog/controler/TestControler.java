package com.nuc.iblog.controler;


import com.nuc.iblog.entity.Article;
import com.nuc.iblog.jpa.ArticleJpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/8 19:23
 * @Description :
 */
@Controller
@RequestMapping
public class TestControler {
    @Autowired
    ArticleJpa articleJpa;
    Logger log = LoggerFactory.getLogger(TestControler.class);
    @RequestMapping("/")
    public String index() {
        return "hello";
    }
    @ResponseBody
    @RequestMapping("/jpa")
    public List<Article>  jpa() {
        List<Article> byAid = articleJpa.findByAid(6);
        log.debug("文章持久层操作：" + byAid);
//        List<Category> all1 = categoryJpa.findAll();
//        log.debug("分类持久层操作："+all1);
//        List<Comments> all2 = commentsJpa.findAll();
//        log.debug("评论持久层操作：" + all2);
//        List<User> all3 = userJap.findAll();
//        log.debug("用户持久层操作："+all3);
        Article article = byAid.get(0);

        return byAid;
    }

}
