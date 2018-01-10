package com.nuc.iblog.jpa;


import com.nuc.iblog.jpa.cl.ClArticleJpa;
import com.nuc.iblog.jpa.ms.MsArticleJpa;

/**
 * @Author hao
 * @Date 2018/1/9 13:08
 * @Description :文章的java持久层api
 */
public interface ArticleJpa extends MsArticleJpa,ClArticleJpa {

}
