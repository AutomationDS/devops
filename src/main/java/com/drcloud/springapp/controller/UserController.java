package com.drcloud.springapp.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final Map<Integer, String> users = new HashMap<>();
    private int idCounter = 1;

    @GetMapping
    public Map<Integer, String> getAllUsers() {
        return users;
    }

    @PostMapping
    public String createUser(@RequestBody String name) {
        users.put(idCounter++, name);
        return "User created: " + name;
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable int id, @RequestBody String name) {
        if (users.containsKey(id)) {
            users.put(id, name);
            return "User updated: " + name;
        }
        return "User not found!";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        if (users.remove(id) != null) {
            return "User deleted!";
        }
        return "User not found!";
    }
}
