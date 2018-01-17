package com.nuc.iblog.entity;

import java.util.List;

/**
 * Created by Tyranitarx on 2018/1/17.
 *
 * @Description :
 */
public class ArticlePage {
    private int totalpage;
    private List<Article> content;

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public List<Article> getContent() {
        return content;
    }

    public void setContent(List<Article> content) {
        this.content = content;
    }
}
