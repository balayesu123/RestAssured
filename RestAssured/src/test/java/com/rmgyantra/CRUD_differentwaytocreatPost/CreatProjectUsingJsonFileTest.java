package com.rmgyantra.CRUD_differentwaytocreatPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreatProjectUsingJsonFileTest {
  @Test
  public void creatProjectUsingJsonfile()
  {
	 File f=new File("C:\\Users\\sivaram\\eclipse-workspace\\RestAssured\\RestAssured\\jsonBody.json");
	 given()
     .contentType(ContentType.JSON)
     .body(f)
     .when()
     .post("http://localhost:8084/addProject")
     .then()
     .assertThat().statusCode(201)
     .and()
     .assertThat().contentType(ContentType.JSON)
     .log().all();
	  
  }
}
