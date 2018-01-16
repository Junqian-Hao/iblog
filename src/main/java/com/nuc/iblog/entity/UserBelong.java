package com.nuc.iblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Tyranitarx on 2018/1/16.
 *
 * @Description :
 */
@Entity
@Table(name = "userbelong")
public class UserBelong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ubid")
    private int ubid;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private User user;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catid")
    private Category category;

    public int getUbid() {
        return ubid;
    }

    public void setUbid(int ubid) {
        this.ubid = ubid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
