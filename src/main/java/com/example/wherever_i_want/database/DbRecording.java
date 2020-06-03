package com.example.wherever_i_want.database;


import com.example.wherever_i_want.domain.City;
import com.example.wherever_i_want.domain.CityList;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class DbRecording {

    private static String id;
    private static String city_name;
    private static String country_code;
    private static StringBuilder sqlQuery;
    private static DbRecording dbRecording;

    private DbRecording() throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        DbManager dbManager = DbManager.getInstance();

        Statement statement = dbManager.getConnection().createStatement();
        CityList cityList = new CityList();
        List<City> list = cityList.getCityList();

        for (int i = 0; i < list.size(); i++) {
            id = list.get(i).getId();
            city_name = list.get(i).getName();
            country_code = list.get(i).getCountryCode();

            sqlQuery = new StringBuilder("INSERT INTO CITIES (city_id, `city_name`, country_code) VALUES " +
                    "(" +"\"" + id  +"\"" + "," +"\"" + city_name + "\"" + "," + "'" + country_code + "'" + ");");

            statement.execute(sqlQuery.toString());
        }
        statement.close();
    }

    public static DbRecording getDbRecording() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        return (dbRecording == null) ? dbRecording = new DbRecording() : dbRecording;
    }

}
