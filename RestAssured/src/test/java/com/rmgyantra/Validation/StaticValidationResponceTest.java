package com.rmgyantra.Validation;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class StaticValidationResponceTest {
   @Test
   public void staticValidationResponce()
   {
	 String exceptedData="sample1111";
	   Response rsps = when().get("http://localhost:8084/projects");
	    String actualData = rsps.jsonPath().get("[2].projectName");
	    Assert.assertEquals(actualData,exceptedData);
		
   }
}
