package com.example.wherever_i_want.domain;

import com.example.wherever_i_want.database.DbManager;
import com.example.wherever_i_want.database.DbRecording;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class URI_List {

    private static final int COLUMN_INDEX = 1;
    private static URI_List uri_list;
    private static StringBuilder sqlQuery;
    private List<String> uriList;

    private URI_List() throws SQLException {
        List<String> list = new ArrayList<>();
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet records = statement.executeQuery("SELECT COUNT(*) FROM CITIES");
        records.next();
        int result = records.getInt("count(*)");

        for (int i = 1; i <= result; i++) {
            ResultSet id = statement.executeQuery("SELECT CITY_ID FROM CITIES where GENERAL_ID =" + i);
            id.next();
            String cityId = id.getString(COLUMN_INDEX);
            sqlQuery = new StringBuilder("https://api.meteostat.net/v1/climate/normals?station=" + cityId + "&key=erPSGcB5");
            list.add(sqlQuery.toString());
        }
        uriList = list.stream().collect(Collectors.toList());
        statement.close();

    }

    public static URI_List getURI_List() throws SQLException {
        return (uri_list == null) ? uri_list = new URI_List() : uri_list;
    }
}
