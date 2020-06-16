package com.example.wherever_i_want.database;

import com.example.wherever_i_want.domain.City;
import com.example.wherever_i_want.domain.CityList;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

public class LocalDatabaseRecording {

    private static String id;
    private static String city_name;
    private static String country_code;
    private static StringBuilder sqlQuery;
    private static LocalDatabaseRecording localDatabaseRecording;

    private LocalDatabaseRecording() throws SQLException, FileNotFoundException, UnsupportedEncodingException {
        DbManager dbManager = DbManager.getInstance();

        Statement statement = dbManager.getConnection().createStatement();
        CityList cityList = new CityList();
        List<City> list = cityList.getCityList();

        int MAX = 40;
        Random random = new Random();

        for (int i = 0; i < list.size(); i++) {
            id = list.get(i).getId();
            city_name = list.get(i).getName();
            country_code = list.get(i).getCountryCode();

            sqlQuery = new StringBuilder("INSERT INTO CITIES_ARTIFICIAL_DATA (city_id, `city_name`, country_code, JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER) VALUES " +
                    "(" +"\"" + id  +"\"" + "," +"\"" + city_name + "\"" + "," + "'" + country_code + "'" + ","  +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) + "," +
                    random.nextInt(MAX) * (random .nextBoolean() ? -1 : 1) +
                    ");");

            statement.execute(sqlQuery.toString());
            System.out.println(i);
        }
        statement.close();
    }

    public static LocalDatabaseRecording getLocalDatabaseRecording() throws FileNotFoundException, UnsupportedEncodingException, SQLException {
        return (localDatabaseRecording == null) ? localDatabaseRecording = new LocalDatabaseRecording() : localDatabaseRecording;
    }
}
