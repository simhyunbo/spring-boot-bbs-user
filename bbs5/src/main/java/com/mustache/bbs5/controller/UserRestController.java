package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.dto.UserRequest;
import com.mustache.bbs5.domain.dto.UserResponse;
import com.mustache.bbs5.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserRestController {


    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest dto) {
        return ResponseEntity.ok().body(userService.addUser(dto));
    }

}
