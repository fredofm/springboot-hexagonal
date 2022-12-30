package com.microservice.prices.springboot.config;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;

@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT)
class PricesControllerIT {
 
  @LocalServerPort
  private Integer port;
 
  /* 
   * petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
   */
  @Test
  void givenProduct35455_Brand1_Date20200614_1000_thenPrice35() {
 
    RestAssured
      .when()
        .get("http://localhost:" + port + "/api/v1/prices/?appDate=2020-06-14T10:00:00&productId=35455&brandId=1")
      .then().log().body()
        .contentType("application/json")   
        .statusCode(200).and()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("priceList", Matchers.equalTo(1))
        .body("startDate", Matchers.equalTo("2020-06-14T00:00:00"))
        .body("endDate", Matchers.equalTo("2020-12-31T23:59:59"))
        .body("price", Matchers.is(35.5F))               
        .extract();
  }

  /* 
   * petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
   */
  @Test
  void givenProduct35455_Brand1_Date20200614_1600_thenPrice25() {
 
    RestAssured
      .when()
        .get("http://localhost:" + port + "/api/v1/prices/?appDate=2020-06-14T16:00:00&productId=35455&brandId=1")
      .then().log().body()
        .contentType("application/json")   
        .statusCode(200).and()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("priceList", Matchers.equalTo(2))
        .body("startDate", Matchers.equalTo("2020-06-14T15:00:00"))
        .body("endDate", Matchers.equalTo("2020-06-14T18:30:00"))
        .body("price", Matchers.is(25.45F))                
        .extract();
  }

  /* 
   * petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
   */
  @Test
  void givenProduct35455_Brand1_Date20200614_2100_thenPrice35() {
 
    RestAssured
      .when()
        .get("http://localhost:" + port + "/api/v1/prices/?appDate=2020-06-14T21:00:00&productId=35455&brandId=1")
      .then().log().body()
        .contentType("application/json")   
        .statusCode(200).and()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("priceList", Matchers.equalTo(1))
        .body("startDate", Matchers.equalTo("2020-06-14T00:00:00"))
        .body("endDate", Matchers.equalTo("2020-12-31T23:59:59"))
        .body("price", Matchers.is(35.50F))                
        .extract();
  }

  /* 
   * petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
   */
  @Test
  void givenProduct35455_Brand1_Date20200615_1000_thenPrice30() {
 
    RestAssured
      .when()
        .get("http://localhost:" + port + "/api/v1/prices/?appDate=2020-06-15T10:00:00&productId=35455&brandId=1")
      .then().log().body()
        .contentType("application/json")   
        .statusCode(200).and()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("priceList", Matchers.equalTo(3))
        .body("startDate", Matchers.equalTo("2020-06-15T00:00:00"))
        .body("endDate", Matchers.equalTo("2020-06-15T11:00:00"))
        .body("price", Matchers.is(30.50F))                
        .extract();
  }

  /* 
   * petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
   */
  @Test
  void givenProduct35455_Brand1_Date20200616_2100_thenPrice38() {
 
    RestAssured
      .when()
        .get("http://localhost:" + port + "/api/v1/prices/?appDate=2020-06-16T21:00:00&productId=35455&brandId=1")
      .then().log().body()
        .contentType("application/json")   
        .statusCode(200).and()
        .body("productId", Matchers.equalTo(35455))
        .body("brandId", Matchers.equalTo(1))
        .body("priceList", Matchers.equalTo(4))
        .body("startDate", Matchers.equalTo("2020-06-15T16:00:00"))
        .body("endDate", Matchers.equalTo("2020-12-31T23:59:59"))
        .body("price", Matchers.is(38.95F))                
        .extract();
  }
}
