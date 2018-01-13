package com.nuc.iblog.service;

import org.springframework.transaction.annotation.Transactional;



/**
 * Created by Tyranitarx on 2018/1/13.
 *
 * @Description :
 */
public interface ClCommentService {
    @Transactional(rollbackFor = Exception.class)
    public int InsertComment(int uid,int aid,String comment);
}
