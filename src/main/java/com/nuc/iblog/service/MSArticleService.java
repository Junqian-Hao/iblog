package com.nuc.iblog.service;

import com.nuc.iblog.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @Author hao
 * @Date 2018/1/12 14:52
 * @Description : 博客管理的业务逻辑层
 */
public interface MSArticleService {
    /**
     * 通过条件查询或者查询所有
     * @param condition
     * @return
     */
    List<Article> select(String condition);

    /**
     * 删除文章
     * @param aid
     * @return
     */
    Map<String, String> delete(int aid);

    /**
     * 查看一篇博文
     * @param aid
     * @return
     */
    Article selectOne(int aid);
}
