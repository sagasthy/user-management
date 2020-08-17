package com.kar.user.repository;

import com.kar.user.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    List<User> users = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User get(String id) {
        Optional<User> foundUser = users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
        /*
        if(foundUser.isPresent())
            return foundUser.get();
        else
            return new User();
         */

        // The above block can be refactored as below
        return foundUser.orElseGet(User::new);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public User update(User user) {

        for (User u1 :
                users) {
            if (u1.getId().equals(user.getId())){
                u1.setName(user.getName());
                u1.setAddress(user.getAddress());
                return u1;
            }
        }

        return new User();
    }

    @Override
    public User delete(String id) {
        User user = get(id);
        boolean removed = users.remove(user);

        if(removed)
            return user;

        return new User();
    }
}
