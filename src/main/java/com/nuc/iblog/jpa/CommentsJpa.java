package com.nuc.iblog.jpa;


import com.nuc.iblog.entity.Comments;
import com.nuc.iblog.jpa.cl.ClCommentsJpa;

/**
 * @Author hao
 * @Date 2018/1/9 13:27
 * @Description : 文章评论jpa接口
 */
public interface CommentsJpa extends ClCommentsJpa, BaseJpa<Comments, Integer> {
}
