package com.apiCalısmaları.day12;

import com.apiCalısmaları.testBase.DummyTestBase;
import com.apiCalısmaları.testData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteRequest01 extends DummyTestBase {
    /*
    http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde
 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "status": "success",
 "data": "2",
 "message": "Successfully! Record has been deleted"
 }
     */
    @Test
    public void test() {
        //url
        spec03.pathParams("parametre1", "delete",
                "parametre2", 2);
        DummyTestData testData = new DummyTestData();
        JSONObject expectedData = testData.setUpDeleteExpectedData();
        Response response = given().
                contentType(ContentType.JSON).
                spec(spec03).
                auth().
                basic("admin", "password123").
                when().
                delete("/{parametre1}/{parametre2}");
        response.prettyPrint();


    }
}