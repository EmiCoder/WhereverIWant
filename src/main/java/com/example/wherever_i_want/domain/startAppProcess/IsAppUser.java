package com.example.wherever_i_want.domain.startAppProcess;

import com.example.wherever_i_want.database.DbManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IsAppUser {

    public boolean isAppUser(String nick, String password) throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        boolean result = statement.execute("select * from users where NICK = " + "'" + nick + "'" + " and EMAIL_PASSWORD = " + "'" + password + "'");
        System.out.println("Nick to : " + nick + " password to " + password);
        System.out.println("Result to " + result);
        statement.close();
        return result;
    }
}
