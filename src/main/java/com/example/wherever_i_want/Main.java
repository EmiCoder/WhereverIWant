package com.example.wherever_i_want;

import com.example.wherever_i_want.domain.*;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws InterruptedException, SQLException {

        UserResponse response = new UserResponse(new UserRequest(25, Month.APRIL, "DE"));
        GoogleMapsShowMethod.show(response.getResponseCitiesList().get(4));
    }

}

