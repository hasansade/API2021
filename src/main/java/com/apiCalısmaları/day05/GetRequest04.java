package com.apiCalısmaları.day05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetRequest04 {

    //https://restful-booker.herokuapp.com/booking/5 url'ine
    //accept type'i "application/json" olan GET request'i yolladigimda
    //gelen response'un
    //status kodunun 200
    //ve content type'inin "application/json"
    //ve firstname'in “Jim"
    //ve totalprice’in 600
    //ve checkin date'in 2015-06-12"oldugunu test edin


    @Test
    public void test02(){

        String url ="https://restful-booker.herokuapp.com/booking/5";

        Response response=given().accept("application/json").when().get(url);

        response.prettyPrint();

        // "firstname": "Sally",
        //    "lastname": "Smith",
        //    "totalprice": 129,
        //    "depositpaid": true,
        //    "bookingdates": {
        //        "checkin": "2021-07-01",
        //        "checkout": "2021-08-01"


        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Sally"),
                        "lastname", equalTo("Jackson"),
                        "totalprice", equalTo(195),
                        "depositpaid",equalTo(false),
                        "bookingdates.checkin",equalTo("2015-12-06"),
                        "bookingdates.checkout", equalTo("2018-01-12"));


    }



}
