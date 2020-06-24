package com.example.wherever_i_want.domain.startAppProcess;

import com.example.wherever_i_want.database.DbManager;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AppStarting {

    public static void start(String nick, String password) throws SQLException {
        if (doesExistUser(nick, password)) {
            DbManager dbManager = DbManager.getInstance();
            Statement statement = dbManager.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select ID from users where NICK = " +  "'" + nick + "'" + " and EMAIL_PASSWORD = " + "'" + password + "'");
            resultSet.next();
            statement.execute("INSERT INTO logs_in (USER_ID, LOGIN_DATE, LOGIN_TIME) VALUES (" + resultSet.getString(1) +"," + "'" + setDate() + "'" + "," + "'" + setTime() + "'" +");");
            statement.close();
        } else {
            User user = createUser("Adam", "Nowak", "Traczyk", 23, "cel@gmail.com");
            DbManager dbManager = DbManager.getInstance();
            Statement statement = dbManager.getConnection().createStatement();
            statement.execute("insert into users (NICK, FIRSTNAME, LASTNAME, AGE, EMAIL, EMAIL_PASSWORD) values(" + "'" + user.getNick() + "'" + ","
                    + "'" + user.getFirstname() + "'" + ", " +
                    "'" + user.getLastname() + "'" + "," +
                    user.getAge() + ", " +
                    "'" + user.getEMail() + "'" + ", " +
                    "'" + user.getPassword() + "'" + ")");

            statement.execute("insert into registers (USER_ID, REGISTER_DATE, REGISTER_TIME) values ((SELECT ID from users WHERE NICK = " + "'" + user.getNick() + "'" + " and EMAIL = " + "'" + user.getEMail() + "'" + ")"  + ", " +
                    "'" + setDate() + "'" + ", " +
                    "'" + setTime() + "'" +")");
            statement.close();
        }

    }

    private static boolean doesExistUser(String nick, String password) throws SQLException {
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet result = statement.executeQuery("select * from users where NICK = " + "'" + nick + "'" + " and EMAIL_PASSWORD = " + "'" + password + "'");
        int r = 0;
        while (result.next()) {
            r++;
        }
        statement.close();
        return (r > 0) ? true : false;
    }

    private static User createUser(String nick, String firstname, String lastname, int age, String eMail) {
        User user = new User();
        user.setNick(nick);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setAge(age);
        user.setEMail(eMail);
        user.setPassword(generatePassword());
        return user;
    }

    private static String generatePassword() {
        return RandomStringUtils.random(10, true, true);
    }


    private static String setDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(calendar.getTime());
    }

    private static String setTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(calendar.getTime());
    }
}
