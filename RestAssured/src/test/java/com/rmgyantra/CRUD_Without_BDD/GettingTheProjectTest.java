package com.rmgyantra.CRUD_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GettingTheProjectTest {
   @Test
   public void gettingTheProjectTest()
   {
	 Response rsps=RestAssured.get("http://localhost:8084/projects");
	// rsps.prettyPrint();
	// System.out.println(rsps.getContentType());
	 //System.out.println(rsps.getHeaders());
	 ValidatableResponse vres = rsps.then();
	 vres.assertThat().statusCode(200);
	 vres.log().all();
   }
}
