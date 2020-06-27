package com.example.wherever_i_want.domain;

import com.example.wherever_i_want.database.DbManager;
import lombok.Getter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Getter
public class UserResponse {

    private final int TEMPERATURE_SCOPE = 2;
    private List<ResponseCity> responseCitiesList;
    private Statement statement;
    private ResultSet rs;

    public UserResponse(Request userRequest) throws SQLException, InterruptedException {
        this.statement = getStatement();
        this.responseCitiesList = getCitiesToGo(userRequest);
    }

    private List<ResponseCity> getCitiesToGo(Request request) throws SQLException, InterruptedException {
        if (request.getCountry() != null) {
            return whenCountryCodeIsNotNull(request);
        } return whenCountryCodeIsNull(request);
    }

    private List<ResponseCity> whenCountryCodeIsNull(Request request) throws SQLException {
        rs = statement.executeQuery("select CITY_ID, CITY_NAME, COUNTRY_CODE from cities_artificial_data where " +
                request.getMonth() + " > " + (request.getTemperature() - TEMPERATURE_SCOPE) + " and " + request.getMonth() +
                " < " + (request.getTemperature() + TEMPERATURE_SCOPE));

        List<ResponseCity> list = new ArrayList<>();
        while (rs.next()) {
            ResponseCity city = new ResponseCity(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3));
            list.add(city);
        }
        statement.close();
        return list;
    }

    private List<ResponseCity> whenCountryCodeIsNotNull(Request request) throws SQLException, InterruptedException {
        rs = getStatement().executeQuery("select CITY_ID, CITY_NAME, COUNTRY_CODE from cities_artificial_data where " +
                request.getMonth() + " > " + (request.getTemperature() - TEMPERATURE_SCOPE) + " and " + request.getMonth() +
                " < " + (request.getTemperature() + TEMPERATURE_SCOPE) + " and COUNTRY_CODE = \'" +request.getCountry() + "\'");

        List<ResponseCity> list = new ArrayList<>();
        while (rs.next()) {
            Statement newStatement = getStatement();
            ResultSet countryName = newStatement.executeQuery("select COUNTRY_NAME from countries where COUNTRY_CODE = \'" + request.getCountry() + "\'");
            countryName.next();
            ResponseCity city = new ResponseCity(
                    rs.getString(1),
                    rs.getString(2),
                    countryName.getString(1));
            list.add(city);
        }
        statement.close();
        return list;
    }


    private Statement getStatement() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        return dbManager.getConnection().createStatement();
    }

}
