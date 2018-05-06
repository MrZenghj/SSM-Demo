package com.snipe.entity;

public class User {
    private Integer id ; // 主键ID
    private String username; // 用户名
    private String account; // 账户
    private String password; // 密码
    private String address; // 地址
    private String status; // 状态 1表示已经激活 0表示未激活
    private Integer age ; // 年龄

    public User() {
    }

    public User(Integer id, String username, String account, String password, String address, String status, Integer age) {
        this.id = id;
        this.username = username;
        this.account = account;
        this.password = password;
        this.address = address;
        this.status = status;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", age=" + age +
                '}';
    }
}
