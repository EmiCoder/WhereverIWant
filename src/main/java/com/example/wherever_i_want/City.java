package com.example.wherever_i_want;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.io.UnsupportedEncodingException;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

    private int id;
    private String name;
    private String country;

    public City(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{id=" + id + ", name= " + name + ", country= " + country + "}";
    }

}
