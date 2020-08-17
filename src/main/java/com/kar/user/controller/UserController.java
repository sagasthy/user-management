package com.kar.user.controller;

import com.kar.user.dto.User;
import com.kar.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController("/")
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id){
        return userService.get(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@RequestBody User user){
        userService.add(user);

        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(path).build();
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/users")
    public User deleteUser(@PathVariable String id){
        return userService.delete(id);
    }
}
