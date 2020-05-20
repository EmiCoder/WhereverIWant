package com.example.wherever_i_want;

import lombok.Getter;

@Getter
public class City {

    private int id;
    private String name;
    private String country;

    public City(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
