package com.apiCalısmaları.day08;

import com.apiCalısmaları.testBase.HerokuAppTestBase;
import com.apiCalısmaları.testData.HerokuappTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends HerokuAppTestBase {

    @Test
    public void test(){
        //url oluşturalım
        spec02.pathParams("parametre1", "booking",
                "parametre2",1);

        //expectedData oluşturalım, ki testdata classında oluşturduk


        HerokuappTestData expectedobje=new HerokuappTestData();

        HashMap<String,Object> expectedDataMap=expectedobje.setUpTestData();

        System.out.println(expectedDataMap);



        //request gönderelim

        Response response=given().
                accept("application/json").
                spec(spec02).
                when().
                get("/{parametre1}/{parametre2}");
        response.prettyPrint();

         //1.yol

        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));

        Assert.assertEquals(     ((Map)expectedDataMap.get("bookingdates")).get("checkin"),
                ((Map)actualDataMap.get("bookingdates")).get("checkin"));

        Assert.assertEquals(     ((Map)expectedDataMap.get("bookingdates")).get("checkout"),
                ((Map)actualDataMap.get("bookingdates")).get("checkout"));




        //2.yol

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedDataMap.get("firstname"),jsonPath.getString("firstname"));
        Assert.assertEquals(expectedDataMap.get("lastname"),jsonPath.getString("lastname"));
        Assert.assertEquals(expectedDataMap.get("totalprice"),jsonPath.getInt("totalprice"));
        Assert.assertEquals(expectedDataMap.get("depositpaid"),jsonPath.getString("depositpaid"));
        Assert.assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin")
                ,jsonPath.getString("bookingdates.checkin"));
        Assert.assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout")
                ,jsonPath.getString("bookingdates.checkout"));

    }

}
