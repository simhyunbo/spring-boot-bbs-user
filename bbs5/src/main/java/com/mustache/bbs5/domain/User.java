package com.mustache.bbs5.domain;

import com.mustache.bbs5.domain.dto.UserDto;
import com.mustache.bbs5.domain.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static UserResponse of(User user) {
        return new UserResponse(user.getId(),
               user.getUsername());

    }
}
