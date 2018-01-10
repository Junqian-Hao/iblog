package com.nuc.iblog.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/9 12:00
 * @Description : 文章实体类
 */
@Table(name = "article")
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private int aid;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "catid")
    private Category category;
    @Column(name = "content")
    private String content;
    @Column(name = "summary")
    private String summary;
    @Column(name = "date")
    private String date;
    @OneToMany
    @JoinColumn(name = "aid", referencedColumnName = "aid")
    private List<Comments> comments;
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
