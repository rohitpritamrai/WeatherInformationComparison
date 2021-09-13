package com.weatherInformation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherForecastPage {

    private static String temperature;
    WebDriver driver;

    @FindBy(xpath = "//div[@class='cur-con-weather-card__panel']/div/div/div[@class='temp']")
    private WebElement searchedResult;

    public WeatherForecastPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /*To fetch the temperature text visible for the searched city*/
    public void getTemperatureValue(){
        String temperature = searchedResult.getText();
        this.temperature = temperature;
    }

    public static String getTemperatureFromWebPage(){
        return temperature;
    }
}
