package com.nuc.iblog.jpa.cl;


import com.nuc.iblog.entity.Comments;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author hao
 * @Date 2018/1/9 13:27
 * @Description : 文章评论jpa接口
 */
@NoRepositoryBean
public interface ClCommentsJpa extends BaseJpa<Comments,Integer> {
    int deleteByCid(int cid);
}
