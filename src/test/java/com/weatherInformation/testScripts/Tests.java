package com.weatherInformation.testScripts;

import com.weatherInformation.APITests.CompareTheTemperature;
import com.weatherInformation.APITests.HttpMethods;
import com.weatherInformation.apiResponseValidation.ResponseValidations;
import com.weatherInformation.customException.InvalidRangeException;
import com.weatherInformation.pages.AccuWeatherHomePage;
import com.weatherInformation.pages.SearchOptionsPage;
import com.weatherInformation.pages.WeatherForecastPage;
import configuration.SetUp;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Tests extends SetUp {

    AccuWeatherHomePage homepage;
    SearchOptionsPage searchOptions;
    WeatherForecastPage resultPage;
    CompareTheTemperature comparator;

    @Test(priority = 2)
    public void fetchTemperatureFromUiApp() {
        homepage = new AccuWeatherHomePage(getDriver());
        homepage.searchCity(properties.getProperty("CITY"));
        searchOptions = new SearchOptionsPage(getDriver());
        searchOptions.confirmSuggestedOption();
        searchOptions.handleAdPopUp();
        resultPage = new WeatherForecastPage(getDriver());
        resultPage.getTemperatureValue();
        properties.setProperty("UI_TEMP", String.valueOf(WeatherForecastPage.getTemperatureFromWebPage()));
        System.out.println("Temperature is "+WeatherForecastPage.getTemperatureFromWebPage());

    }

    @Test(priority = 1)
    public void fetchTemperatureFromAPI() {
        HttpMethods httpMethods=new HttpMethods(properties);
        Response response=httpMethods.GetRequest(properties.getProperty("BASE_URI"));
        ResponseValidations resValidation=new ResponseValidations();
        resValidation.ResponseValidation(response);
        properties.setProperty("API_TEMP",response.jsonPath().get("main.temp").toString());
        resValidation.SetTemperatureValue(properties.getProperty("API_TEMP"));
    }

    @Test(priority = 3)
    public void compareTemperature() {
        comparator = new CompareTheTemperature();
        try {
            comparator.Variance();
        } catch (InvalidRangeException e) {
            e.printStackTrace();
        }
    }
}
