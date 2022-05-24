package com.Practies;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import  static io.restassured.RestAssured.*;

public class Nested_payloadTest {
   @Test
   public void nestedPaylod()
   {
//      JSONObject com = new JSONObject();
//      com.put("company", "ABC");
//      
//      JSONObject emp = new JSONObject();
//      emp.put("name", "Ram");
//      
//      com.put("Employee", emp);
//      System.out.println(com.toString());
      
	   JSONObject job = new JSONObject();
	   
	   job.put("employe","vikky");
	   job.put("id", 001);
      
	   given()
	   .contentType(ContentType.JSON)
	   .body(job)
      .when()
      .post("http://localhost:8084/addProject")
      .then()
      .assertThat().statusCode(201)
      .log().all();
      
   }
}
