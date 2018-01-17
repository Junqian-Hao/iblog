package com.nuc.iblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * @Author hao
 * @Date 2018/1/9 12:00
 * @Description :用户实体类
 */
@Table(name = "user")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid")
    private int uid;
    @Column(name = "username")
    private String username;
    @Column(name="nickname")
    private String nickname;
    @Column(name = "password")
    private String password;
    @Column(name = "is_admin")
    private Integer isAdmin;
    @Column(name = "academyid")
    private int academyid;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academyid",referencedColumnName = "catid",insertable = false,updatable = false)
    private Category college;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid",referencedColumnName = "uid")
    private List<Article> articles;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userbelong", joinColumns = @JoinColumn(name = "uid"), inverseJoinColumns = @JoinColumn(name = "catid"))
    private List<Category> categories;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getAcademyid() {
        return academyid;
    }

    public void setAcademyid(int academyid) {
        this.academyid = academyid;
    }

    public Category getCollege() {
        return college;
    }

    public void setCollege(Category college) {
        this.college = college;
    }
}
