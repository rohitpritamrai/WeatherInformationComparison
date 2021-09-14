package com.weatherInformation.APITests;

import com.weatherInformation.apiResponseValidation.ResponseValidations;
import com.weatherInformation.customException.InvalidRangeException;
import com.weatherInformation.pages.WeatherForecastPage;


public class CompareTheTemperature {

    public int uiTemp;
    public int apiTemp;
    public void CompareTemperature() {
        uiTemp = WeatherForecastPage.getTemperatureFromWebPage();
        apiTemp = ResponseValidations.GetTemperatureValue();
    }

    public void Variance() throws InvalidRangeException {
        CompareTemperature();
        if(uiTemp - apiTemp > 4){
            throw new InvalidRangeException("Temperatures doesn't match");
        }else {
            System.out.println("Temperature are in Range :"+uiTemp+", "+apiTemp);
        }
    }
}
