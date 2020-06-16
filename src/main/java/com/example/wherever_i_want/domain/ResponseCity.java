package com.example.wherever_i_want.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseCity {

    private String cityId;
    private String cityName;
    private String countryName;
}
