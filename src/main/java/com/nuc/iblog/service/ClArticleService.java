package com.nuc.iblog.service;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.entity.Category;
import com.nuc.iblog.entity.User;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
public interface ClArticleService {
    @Transactional(rollbackFor = Exception.class)
    public Article getArticle(int aid);

    @Transactional(rollbackFor = Exception.class)
    public List<Article> getArticles();

    @Transactional(rollbackFor = Exception.class)
    public List<Article> getArticlesByUser(int uid);

    @Transactional(rollbackFor = Exception.class)
    public List<Article> getArticleByUserAndCategory(int uid,int catid);

    @Transactional(rollbackFor = Exception.class)
    public int InsertArticle(int uid, String catname, String title, String summary, String content);

    @Transactional(rollbackFor = Exception.class)
    public int UpdateArticle(int uid, int aid, String catname, String title, String summary, String content);
}
