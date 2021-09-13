package com.weatherInformation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOptionsPage {
    WebDriver driver;

    @FindBy(css = "body > div > div.two-column-page-content > div.page-column-1 > div.content-module > div.locations-list.content-module > a:nth-child(1)")
    private WebElement searchOption;

    @FindBy(xpath = "//*[@id='dismiss-button']")
    private WebElement dismissBtn;

    /* To initialize the WebElements and WebDriver through PageFactory using it's constructor */
    public SearchOptionsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /*This method is to chose the option provided for the searched city value */
    public void confirmSuggestedOption(){
        if(searchOption.isDisplayed()){
            searchOption.click();
        }else {
            throw new NoSuchElementException("Searched city is not present");
        }
    }
}
