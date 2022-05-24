package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
  @Test
  public void besicAuth()
  {
	 given()
	 .auth()
	 .oauth2("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")
	 .when()
	 .get("https://api.github.com/user/repos")
	 .then()
	 .log()
	 .all();
	 
	
  }
}
