package com.design.patterns.ObserverDesignPattern.Controller;

import com.design.patterns.ObserverDesignPattern.Service.EmailObserver;
import com.design.patterns.ObserverDesignPattern.Service.SMSObserver;
import com.design.patterns.ObserverDesignPattern.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;


    public UserController() {
        this.userService = new UserService();
        // Register observers
        userService.registerObserver(new EmailObserver());
        userService.registerObserver(new SMSObserver());
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username) {
        userService.registerUser(username);
        return ResponseEntity.ok("User registered and notifications sent!");
    }
}
