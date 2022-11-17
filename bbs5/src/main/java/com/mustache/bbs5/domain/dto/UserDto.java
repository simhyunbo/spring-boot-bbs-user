package com.mustache.bbs5.domain.dto;

import com.mustache.bbs5.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private Long id;
    private String username;
    private String password;


    public User toEntity() {
        return new User(this.id, this.username, this.password);
    }
}