package com.rmgyantra.RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestTest {
   @Test
   public void requestget()
   {
	  Response rsps = when().get("http://localhost:8084/projects");
	  String projectid = rsps.jsonPath().get("[1].projectId");
	  System.out.println(projectid);
	  
	  given()
		.pathParam("proId",projectid )
		.when()
		.delete("http://localhost:8084/projects/{proId}")
		.then()
		.assertThat()
		.statusCode(204);
   }
}
