package com.mustache.bbs5.domain.dto;

import com.mustache.bbs5.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String username;
    private String password;

    public User toEntity() {
        return User.builder()
                .username(this.username)
                .password(this.password)
                .build();
    }
}