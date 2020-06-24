package com.example.wherever_i_want;


import com.example.wherever_i_want.domain.startAppProcess.IsAppUser;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        IsAppUser isAppUser = new IsAppUser();
        System.out.println(isAppUser.isAppUser("Sam", "jbkjbs"));

    }

}

