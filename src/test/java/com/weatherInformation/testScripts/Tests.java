package com.weatherInformation.testScripts;

import com.weatherInformation.pages.AccuWeatherHomePage;
import com.weatherInformation.pages.SearchOptionsPage;
import com.weatherInformation.pages.WeatherForecastPage;
import configuration.SetUp;
import org.testng.annotations.Test;

public class Tests extends SetUp {

    AccuWeatherHomePage homepage;
    SearchOptionsPage searchOptions;
    WeatherForecastPage resultPage;

    @Test
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
}
