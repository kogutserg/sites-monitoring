package com.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/reg")
public class MainController {
    @Autowired
    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name,
                                            @RequestParam String email,
                                            @RequestParam String password) {
        User n = new User();
        n.setUser(name);
        n.setEmail(email);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

    @PostMapping(path = "/updatePass")
    public @ResponseBody String updatePassword(Long id, String password) {
        User user = userRepository.findById(id);
//        user.setPassword(passwordEncoder.encode(password));
        user.setPassword(password);
        userRepository.save(user);
        return "Password updated";
    }

    @PostMapping(path = "/delete")
    public @ResponseBody String deleteUser(Long id) {
        return "The user has been deleted";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }


}
