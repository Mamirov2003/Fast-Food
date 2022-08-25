package com.example.userservice.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author "ISMOIL NIGMATOV"
 * @created 11:30 PM on 8/10/2022
 * @project fast-food
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    @NotNull
    private String phone;
    @NotNull
    private String fullName;
    @NotNull
    private String password;
    @NotNull
    private String secondPassword;
    @NotNull
    private String region;
    @NotNull
    private boolean agreement;
}
