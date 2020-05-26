package com.example.wherever_i_want.domain;

import com.example.wherever_i_want.domain.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CityList {

    private List<City> cityList;

    public CityList() throws FileNotFoundException, UnsupportedEncodingException {
        this.cityList = prepareCityList();
    }

    private List<City> prepareCityList() throws FileNotFoundException, UnsupportedEncodingException {
        List<City> list = new ArrayList<>();

        Gson gson = new Gson();

        JsonReader reader = new JsonReader(
                new InputStreamReader(
                        new FileInputStream("src/main/resources/stations.json"), "UTF-8"));
        list = gson.fromJson(reader, CITY_TYPE);
        return list;
    }

    private final Type CITY_TYPE = new TypeToken<List<City>>() {
    }.getType();
}
