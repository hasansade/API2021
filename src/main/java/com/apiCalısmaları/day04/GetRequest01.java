package com.apiCalısmaları.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
public class GetRequest01 {
    //https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
    //ØHTTP status kodunun 200
    //ØContent Type’in Json
    //ØVe Status Line’in HTTP/1.1 200 OK
    //Oldugunu test edin

@Test
        public void test01(){
    //1-Api testi yaparken ilk olarak URL (endpoint) belirlenmeli
    String url="https://restful-booker.herokuapp.com/booking/3";

    //2- beklenen sonuc (expected result) olusturulur


    //bu case de benden body dogrulamsı istemedigi icin simdilik eklenen sonuc olusturmuyoruz

    //3-request gonder

    Response response= given().accept("application/json").when().get(url);
    response.prettyPrint();

   /* response.then().assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .statusLine("HTTP/1.1 200 OK");
*/


    //4- actual result olustur
//response body ile islem yapmıycaz, simdi olusturmıycaz
    //5-dogrulama yap (assertion yap)

    System.out.println("Status code : "  +response.getStatusCode());
    System.out.println("Content Type : "  +response.getContentType());
    System.out.println("Status line : " + response.getStatusLine());

    System.out.println("Header : " + response.getHeaders());
/*
    Assert.assertEquals(200, response.getStatusCode());
    //expected bize task olarak verilen deger, actual: response den donen deger
    //status code int deger dondurur

    Assert.assertEquals("application/json; charset=utf-8", response.getContentType());

    Assert.assertEquals("HTTP/1.1 200 OK", response.getStatusLine());

*/

    response.then().assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .statusLine("HTTP/1.1 200 OK");

}

}
