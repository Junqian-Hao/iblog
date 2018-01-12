package com.nuc.iblog.jpa.ms;

import com.nuc.iblog.entity.Article;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/10 11:19
 * @Description :
 */
@NoRepositoryBean
public interface MsArticleJpa extends BaseJpa<Article,Integer> {
    Article findByAid(int aid);

    @Query(value = "SELECT DISTINCT article.*, category.*, user.* FROM article LEFT JOIN blog.`user` ON article.`uid` = user.`uid` LEFT JOIN category ON article.`catid` = category.`catid` WHERE (article.`title` LIKE CONCAT('%',:username,'%') OR article.`content` LIKE CONCAT('%',:username,'%') OR article.`summary` LIKE CONCAT('%',:username,'%') OR article.`date` LIKE CONCAT('%',:username,'%') OR user.`username` LIKE CONCAT('%',:username,'%') OR category.`name` LIKE CONCAT('%',:username,'%'))", nativeQuery = true)
    List<Article> selecrArticle(@Param("username") String keyName);
}
