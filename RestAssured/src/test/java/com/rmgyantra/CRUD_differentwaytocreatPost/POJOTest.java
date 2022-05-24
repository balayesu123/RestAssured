package com.rmgyantra.CRUD_differentwaytocreatPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.POJOClass;

import static io.restassured.RestAssured.*;

public class POJOTest {
  @Test
  public void pojotest() {
	 POJOClass p=new POJOClass("Blayesu","SDET-Pojo","ctreated",5);
	 given()
     .contentType(ContentType.JSON)
     .body(p)
     .when()
     .post("http://localhost:8084/addProject")
     .then()
     .log().all();
  }
}
