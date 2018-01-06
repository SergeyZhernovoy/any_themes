package com.boot.edu.healthcare.repository;

import com.boot.edu.healthcare.domain.User;

import java.util.List;

/**
 * @author Sergey Zhernovoy
 * create on 05.01.2018.
 */
public interface UserDAO {
    List<User> findByEmail(String email);
    List<User> findByEmailAndPassword(String email, String password);
    void update(User user);
}
