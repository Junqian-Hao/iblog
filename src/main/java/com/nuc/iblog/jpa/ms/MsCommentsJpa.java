package com.nuc.iblog.jpa.ms;


import com.nuc.iblog.entity.Comments;
import com.nuc.iblog.jpa.BaseJpa;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author hao
 * @Date 2018/1/9 13:27
 * @Description : 文章评论jpa接口
 */
@NoRepositoryBean
public interface MsCommentsJpa extends BaseJpa<Comments,Integer> {
}
