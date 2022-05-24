package com.rmgyantra.CRUD_differentwaytocreatPost;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMapTest {
   @Test
   public void creatProjectUsingHashMap()
   {
	  HashMap hm=new HashMap();
	   hm.put("createdBy","Balayesu");
	   hm.put("projectName", "SDET-5-HY-HashMap");
	   hm.put("status", "created");
	   hm.put("teamSize", 5);
	   
	   given()
       .contentType(ContentType.JSON)
       .body(hm)
       .when()
       .post("http://localhost:8084/addProject")
       .then()
       .assertThat().statusCode(201)
       .and()
       .assertThat().contentType(ContentType.JSON)
       .log().all();
   }
}
