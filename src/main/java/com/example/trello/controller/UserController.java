package com.example.trello.controller;

import com.example.trello.entity.User;
import com.example.trello.service.StateHistoryService;
import com.example.trello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is a User Controller which has all the endpoints for CRUD operation related to Users/ Engineers
 */
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private StateHistoryService stateHistoryService;

    /**
     * This API will add user/engineer to the user table.
     */
    @PostMapping("/user/addUser")
    public User addUser(@RequestBody User user) {
        User new_user= service.saveUser(user);
        return new_user;
    }

    /**
     *  This API will add multiple users to the table
      * @param users
     * @return
     */
    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    /**
     * This API will print all the users in the table
     * @return
     */

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getUsers();
    }

    /**
     * This API will print all details about a specific user.
     * @param id
     * @return
     */
    @GetMapping("/userById/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    /**
     * This will delete a specific user
     * @param id
     * @return
     */

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
