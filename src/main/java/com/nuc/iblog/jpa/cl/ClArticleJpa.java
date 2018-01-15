package com.nuc.iblog.jpa.cl;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.entity.Category;
import com.nuc.iblog.entity.User;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/10 11:49
 * @Description :
 */
@NoRepositoryBean
public interface ClArticleJpa extends BaseJpa<Article,Integer> {
    Article findByAid(int aid);
    List<Article> findByUserAndCategory(User user, Category category);
    List<Article> findByCategory(Category category);
    Page<Article> findByUser(User user, Pageable pageable);
    int deleteArticleByAid(int aid);
}
