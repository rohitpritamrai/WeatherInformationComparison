package com.weatherInformation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccuWeatherHomePage {

    WebDriver driver;
    @FindBy(xpath = "//input[@name='query']")
    private WebElement search_textBox;

    /* To initialize the page elements and WebDriver on Homepage using PageFactory*/
    public AccuWeatherHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /*This method is to provide the city name into searchbox on HomePage */
    public void searchCity(String city){
        search_textBox.sendKeys(city);
        search_textBox.sendKeys(Keys.ENTER);
    }

}
