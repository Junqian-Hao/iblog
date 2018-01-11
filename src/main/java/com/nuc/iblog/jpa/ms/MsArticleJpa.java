package com.nuc.iblog.jpa.ms;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/10 11:19
 * @Description :
 */
@NoRepositoryBean
public interface MsArticleJpa extends BaseJpa<Article,Integer> {
    Article findByAid(int aid);
}
