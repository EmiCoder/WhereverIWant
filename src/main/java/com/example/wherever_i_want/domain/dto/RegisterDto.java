package com.example.wherever_i_want.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class RegisterDto {
    private int id;
    private int userId;
    private String registerDate;
    private String registerTime;
}
