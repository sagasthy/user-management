package com.kar.user.service;

import com.kar.user.dto.User;
import com.kar.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User get(String id) {
        return userRepository.get(id);
    }

    @Override
    public void add(User user) {
        userRepository.add(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User delete(String id) {
        return userRepository.delete(id);
    }
}
