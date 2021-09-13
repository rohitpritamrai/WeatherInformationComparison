package com.weatherInformation.APITests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Properties;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class HttpMethods {
    static Properties properties;

    public HttpMethods(Properties properties) {
        this.properties=properties;
    }

    public Response GetRequest(String URI) {
        baseURI=URI;

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .queryParam("q",properties.getProperty("CITY"))
                        .queryParam("appid", properties.getProperty("APP_ID"))
                        .get("/weather");
        return response;
    }
}
