package com.rmgyantra.Authentication;

import static io.restassured.RestAssured.given;

public class BasicAuthTest {
	public void besicAuth()
	  {
		 given()
		 .auth()
		 .basic("rmgyantra", "rmgy@9999")
		 .when()
		 .get("http://localhost:8084/login")
		 .then()
		 .log()
		 .all();
		 
		
	  }
}
