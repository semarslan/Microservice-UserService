package com.semarslan.user.controller;

import com.semarslan.user.entity.User;
import com.semarslan.user.service.UserService;
import com.semarslan.user.valueObject.ResponseTemplateVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");

        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
