package com.controller;

import com.entity.User;
import com.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/reg")
public class RegisterController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/list")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/listUser")
    public @ResponseBody
    User getUser(@RequestParam Long id) {
        return userRepository.findByUserId(id);
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewUser(@RequestParam String name,
                      @RequestParam String email,
                      @RequestParam String password) {
        User user = new User();
        user.setUser(name);
        user.setEmail(email);
        user.setPassword(DigestUtils.sha256Hex(password));
        userRepository.save(user);
        return "Saved";
    }

    @PostMapping(path = "/login")
    public @ResponseBody
    boolean userLogin(@RequestParam String email, @RequestParam String password) {
        boolean loginInfo = false;
        User user;
        try {
            user = userRepository.findByEmail(email);
            String emailFromDb = user.getEmail();
            String passFromDb = user.getPassword();
            if ((email.equals(emailFromDb)) && (DigestUtils.sha256Hex(password).equals(passFromDb))) {
                loginInfo = true;
            }
        } catch (NullPointerException ex) {
            System.out.println("User with the email " + email + " is not registered");
        }
        return loginInfo;
    }

    @PostMapping(path = "/updatePass")
    public @ResponseBody
    String updatePassword(@RequestParam Long id, @RequestParam String password) {
        try {
            User user = userRepository.findByUserId(id);
            user.setPassword(DigestUtils.sha256Hex(password));
            userRepository.save(user);
            return "Password updated";
        } catch (NullPointerException ex) {
            return "The user with id " + id + " does not exist!";
        }
    }

    @DeleteMapping(path = "/delete")
    public @ResponseBody
    String deleteUser(@RequestParam Long id) {
        try {
            User user = userRepository.findByUserId(id);
            userRepository.delete(user);
            return "The user with id " + id + " has been deleted";
        } catch (Exception ex) {
            return "The user with id " + id + " does not exist!";
        }
    }
}
