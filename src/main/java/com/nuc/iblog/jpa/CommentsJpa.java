package com.nuc.iblog.jpa;


import com.nuc.iblog.jpa.cl.ClCommentsJpa;
import com.nuc.iblog.jpa.ms.MsCommentsJpa;

/**
 * @Author hao
 * @Date 2018/1/9 13:27
 * @Description : 文章评论jpa接口
 */
public interface CommentsJpa extends ClCommentsJpa,MsCommentsJpa {
}
