package com.turkcell.user_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/api/users")
@RestController
public class UsersController {
    @GetMapping
    public String get() {
        System.out.println("UsersController çalıştı");
        return "UsersController";
    }
}
