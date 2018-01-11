package com.nuc.iblog.service;

import com.nuc.iblog.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Tyranitarx on 2018/1/11.
 *
 * @Description :
 */
public interface ArticleService {
    public Article getArticle(int aid);
    public List<Article> getArticles();
    public List<Article> getArticlesByUser(int uid);
}
