package com.example.wherever_i_want;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CityList {

    private List<City> cityList;

    public CityList() {
        this.cityList = new ArrayList<>();
    }

}
