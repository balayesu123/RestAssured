package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreatingTheProjectTest {
   @Test
   public void creatingTheProject()
   {
	   JSONObject jobj=new JSONObject();
	   jobj.put("createdBy","Balayesu");
	   jobj.put("projectName", "SDET-5-HYD-RestAssured1");
	   jobj.put("status", "created");
	   jobj.put("teamSize", 5);
	 //request object
	  RequestSpecification rspec = RestAssured.given();
	  rspec.contentType(ContentType.JSON);
	  rspec.body(jobj);
	//response object
	  Response rsps = rspec.post("http://localhost:8084/addProject");
	//  validaton 
	  ValidatableResponse vres = rsps.then();
	  vres.assertThat().statusCode(201);
	  vres.log().all();
   }
}
