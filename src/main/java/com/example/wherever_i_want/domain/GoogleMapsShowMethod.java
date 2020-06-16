package com.example.wherever_i_want.domain;

import com.example.wherever_i_want.web.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMapsShowMethod {

    public static void show(ResponseCity city) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.google.pl/maps/@52.1065387,21.3352448,13z");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"searchboxinput\"]"));
        element.sendKeys(city.getCityName() + " " + city.getCountryName());
        WebElement lookForElement = driver.findElement(By.xpath("//*[@id=\"searchbox-searchbutton\"]"));
        lookForElement.click();
    }
}
