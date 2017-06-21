package ru.bibl.web.domain;/**
 * @author Sergey Zhernovoy
 * create on 21.06.2017.
 */

public class User {
    private String userName;
    private String password;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

    