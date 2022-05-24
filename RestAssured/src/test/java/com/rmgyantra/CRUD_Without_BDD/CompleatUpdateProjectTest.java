package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CompleatUpdateProjectTest {
	 @Test
	   public void updateTheProject()
	   {
		   JSONObject jobj=new JSONObject();
		   jobj.put("createdBy","Balayesu");
		   jobj.put("projectName", "SDET-5-HYD-RestAssured1234");
		   jobj.put("status", "created");
		   jobj.put("teamSize", 5);
		  RequestSpecification rspec = RestAssured.given();
		  rspec.contentType(ContentType.JSON);
		  rspec.body(jobj);
		  Response rsps = rspec.put("http://localhost:8084/projects/TY_PROJ_1602");
		  ValidatableResponse vres = rsps.then();
		  vres.assertThat().statusCode(200);
		  vres.log().all();
	   }
}
