package com.example.wherever_i_want.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class UserDto {

    private int id;
    private String nick;
    private String firstname;
    private String lastname;
    private int age;
    private String eMail;
    private String password;
}
