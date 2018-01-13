package com.nuc.iblog.service.imp;

import com.nuc.iblog.entity.Comments;
import com.nuc.iblog.jpa.ArticleJpa;
import com.nuc.iblog.jpa.CommentsJpa;
import com.nuc.iblog.jpa.UserJpa;
import com.nuc.iblog.service.ClCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tyranitarx on 2018/1/13.
 *
 * @Description :
 */
@Service
public class ClCommentServiceImp implements ClCommentService {
    @Autowired
    private CommentsJpa commentsJpa;
    @Autowired
    private UserJpa userJpa;
    @Autowired
    private ArticleJpa articleJpa;

    private Comments comments;
    @Override
    public int InsertComment(int uid,int aid,String comment) {
            comments=new Comments();
            comments.setUser(userJpa.findByUid(uid));
            comments.setArticle(articleJpa.findByAid(aid));
            comments.setComment(comment);
            commentsJpa.save(comments);
            return 1;
    }
}
