package com.nuc.iblog.service.imp;

import com.nuc.iblog.controler.TestControler;
import com.nuc.iblog.entity.Article;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.ArticleJpa;
import com.nuc.iblog.jpa.UserJpa;
import com.nuc.iblog.service.ArticleService;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
@Service
public class ArticleServiceImp implements ArticleService {
    Logger log = org.slf4j.LoggerFactory.getLogger(ArticleServiceImp.class);
    @Autowired
    private ArticleJpa articleJpa;
    @Autowired
    private UserJpa userJpa;
    private Article article;
    private List<Article> articles;

    @Override
    public Article getArticle(int aid) {
        article = articleJpa.findByAid(aid);
        return article;
    }

    private int num;
    private List<Article> returnArticle;

    @Override
    public List<Article> getArticles() {
        returnArticle = new ArrayList<Article>();
        articles = articleJpa.findAll();
        for (int i = 0; i < 5; i++) {
            num = (int) (Math.random() * articles.size());
            article = articles.get(num);
            if (!returnArticle.contains(article))
                returnArticle.add(article);
        }
        return returnArticle;
    }

    private User user;
    @Override
    public List<Article> getArticlesByUser(int uid) {
            user=userJpa.findByUid(uid);
            return user.getArticles();
    }
}
