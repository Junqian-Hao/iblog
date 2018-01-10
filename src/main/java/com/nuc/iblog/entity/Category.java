package com.nuc.iblog.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/9 12:00
 * @Description : 类别实体类
 */
@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catid")
    private int catid;
    @Column(name = "name")
    private String name;
    @Column(name = "display_name")
    private String displayName;
    @OneToMany
    @JoinColumn(name = "catid")
    private List<Article> article;


    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }


}
