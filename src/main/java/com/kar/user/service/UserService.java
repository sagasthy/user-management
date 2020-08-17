package com.kar.user.service;

import com.kar.user.dto.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User get(String id);

    void add(User user);

    User update(User user);

    User delete(String id);

}

