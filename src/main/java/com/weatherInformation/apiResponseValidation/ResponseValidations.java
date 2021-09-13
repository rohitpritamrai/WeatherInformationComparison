package com.weatherInformation.apiResponseValidation;

import io.restassured.response.Response;

public class ResponseValidations {

    private static int temperature;

    public static int GetTemperatureValue() {
        return temperature;
    }
    public void SetTemperatureValue(String temp) {
        temperature= (int) Float.parseFloat(temp.substring(0,3));
        temperature=(temperature-273);
        System.out.println("Temperature in Kelvin "+temperature);
    }

    public void ResponseValidation(Response response) {
        System.out.println(response.getStatusLine());
        System.out.println(response.asString());
    }

}
