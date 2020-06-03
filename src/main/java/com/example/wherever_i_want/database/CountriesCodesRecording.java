package com.example.wherever_i_want.database;

import com.example.wherever_i_want.domain.Country;
import com.example.wherever_i_want.web.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.sql.Statement;

public class CountriesCodesRecording {

    private static final String SOURCE = "https://pl.wikipedia.org/wiki/ISO_3166-1_alfa-2#AO";
    public static WebElement countryCode;
    public static WebElement countryName;
    private static StringBuilder sqlQuery;
    private static CountriesCodesRecording countriesCodesRecording;

    private CountriesCodesRecording() throws SQLException, InterruptedException {
        DbManager dbManager = DbManager.getInstance();

        Statement statement = dbManager.getConnection().createStatement();

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(SOURCE);
        Thread.sleep(500);

        for (int i = 1; i < 250; i++) {
            countryCode = driver.findElement(By.xpath("//html/body/div[3]/div[3]/div[4]/div/table[1]/tbody/tr[" + i + "]/td[3]/a/tt"));
            countryName = driver.findElement(By.xpath("//html/body/div[3]/div[3]/div[4]/div/table[1]/tbody/tr[" + i + "]/td[2]"));
            Country country = new Country();
            country.setName(countryName.getText());
            country.setCode(countryCode.getText());

            sqlQuery = new StringBuilder("INSERT INTO COUNTRIES (COUNTRY_NAME, COUNTRY_CODE) VALUES " +
                    "(" + "\"" + countryName.getText() + "\"" + "," + "'" + countryCode.getText() + "'" + ");");
            statement.execute(sqlQuery.toString());
        }
        statement.close();
    }

    public static CountriesCodesRecording getCountriesCodesRecording() throws FileNotFoundException, UnsupportedEncodingException, SQLException, InterruptedException {
        return (countriesCodesRecording == null) ? countriesCodesRecording = new CountriesCodesRecording() : countriesCodesRecording;
    }
}
