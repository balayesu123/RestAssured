package com.rmgyantra.CRUD_Without_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PartiallyUpdateTheProjectTest {
	 @Test
	   public void partiallyUpdateTheProject()
	   {
		   JSONObject jobj=new JSONObject();
		   jobj.put("name","Bala");
		   jobj.put("projectName", "SDET-5-HYD-RestAssured12");
		   
		  RequestSpecification rspec = RestAssured.given();
		  rspec.contentType(ContentType.JSON);
		  rspec.body(jobj);
		  Response rsps = rspec.patch("https://reqres.in/api/users/2");
		  ValidatableResponse vres = rsps.then();
		  vres.assertThat().statusCode(200);
		  vres.log().all();
	   }
}
