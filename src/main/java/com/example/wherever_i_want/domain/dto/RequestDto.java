package com.example.wherever_i_want.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class RequestDto {

    private int id;
    private int userId;
    private int temperature;
    private String month;
    private String country;
    private String requestDate;
}
