package com.softserve.academy.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String login;
    private String password;
    private Timestamp createDate = new Timestamp(new Date().getTime());
    private Phone phone;
    private List<Blog> posts;
    private List<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public List<Blog> getPosts() {
        return posts;
    }

    public void setPosts(List<Blog> posts) {
        this.posts = posts;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
