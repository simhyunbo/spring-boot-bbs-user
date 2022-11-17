package com.mustache.bbs5.service;

import com.mustache.bbs5.domain.User;
import com.mustache.bbs5.domain.dto.UserDto;
import com.mustache.bbs5.domain.dto.UserRequest;
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
        if (optUser.isEmpty()) {
            return new UserResponse(id, "", "해당 id의 유저가 없습니다");
        } else {
            User user = optUser.get();
            return new UserResponse(user.getId(), user.getUsername(), "");
        }
    }

    public UserResponse addUser(UserRequest userRequest){
        User user = userRequest.toEntity();
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getUsername() , "회원 등록 성공");
    }
}
