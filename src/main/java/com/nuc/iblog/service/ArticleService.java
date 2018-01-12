package com.nuc.iblog.service;

import com.nuc.iblog.entity.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
public interface ArticleService {
    @Transactional(rollbackFor = Exception.class)
    public Article getArticle(int aid);
    @Transactional(rollbackFor = Exception.class)
    public List<Article> getArticles();
    @Transactional(rollbackFor = Exception.class)
    public List<Article> getArticlesByUser(int uid);
    @Transactional(rollbackFor = Exception.class)
    public int InsertArticle(int uid, int catid,String title,String summary,String content);
}
