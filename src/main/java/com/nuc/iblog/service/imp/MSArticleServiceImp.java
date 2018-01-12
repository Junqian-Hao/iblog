package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.jpa.ArticleJpa;
import com.nuc.iblog.service.MSArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 14:59
 * @Description :
 */
@Service
public class MSArticleServiceImp implements MSArticleService {
    @Autowired
    ArticleJpa articleJpa;
    @Override
    public List<Article> select(String condition) {
        if (condition == null || "".equals(condition)) {
            List<Article> all = articleJpa.findAll();
            return all;
        } else {
            List<Article> articles = articleJpa.selecrArticle(condition);
            return articles;
        }

    }

    @Override
    public Map<String, String> delete(int aid) {
        HashMap<String, String> map = new HashMap<String, String>();
        articleJpa.delete(aid);
        map.put("code", "1");
        return map;
    }

    @Override
    public Article selectOne(int aid) {
        Article one = articleJpa.findOne(aid);
        return one;
    }
}
