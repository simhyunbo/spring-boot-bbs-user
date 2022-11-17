package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.User;
import com.mustache.bbs5.domain.dto.UserResponse;
import com.mustache.bbs5.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getUser(Long id) {
        Optional<User> optUser = userRepository.findById(id);
        User user = optUser.get();
        UserResponse userResponse = user.of(user);

        return userResponse;
    }

}
