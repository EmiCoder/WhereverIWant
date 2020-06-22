package com.example.wherever_i_want.scheduler;

import com.example.wherever_i_want.database.DbManager;
import com.example.wherever_i_want.domain.URI_List;
import com.example.wherever_i_want.meteo.client.StationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


@Component
public class MeteostatApiRequest {

    @Autowired
    private StationClient stationClient;
    private static final String SQL_QUERY = "select  LAST_ID_SAVED from last_city_id_saved";


    @Scheduled(cron = "* 0 10 * * *")
    public void sendRequestToMeteostatApi() throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(SQL_QUERY);
        rs.next();
        int tmpElement = Integer.parseInt(rs.getString(1));
        statement.executeUpdate("UPDATE last_city_id_saved SET LAST_ID_SAVED = " + (tmpElement + 1));

        ResultSet cityId = statement.executeQuery("select CITY_ID from cities where GENERAL_ID = " + (tmpElement + 1));
        cityId.next();
        String id = cityId.getString(1);

        stationClient.getStation(id, new StringBuilder(list().get(tmpElement)).toString());
        statement.close();
    }

    private List<String> list() throws SQLException {
        List<String> list = URI_List.getURI_List().getUriList();
        return list;
    }
}
