package com.rmgyantra.CRUD_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class CreateProjectTest {
  @Test
  public void createProject()
  { 
	  JSONObject jobj=new JSONObject();
	   jobj.put("createdBy","Balayesu");
	   jobj.put("projectName", "SDET-5-HY-DwithBDD1");
	   jobj.put("status", "created");
	   jobj.put("teamSize", 5);
	    
	   given()
	       .contentType(ContentType.JSON)
	       .body(jobj)
	       .when()
	       .post("http://localhost:8084/addProject")
	       .then()
	       .assertThat().statusCode(201)
	       .and()
	       .assertThat().contentType(ContentType.JSON)
	       .log().all();   
  }
}
