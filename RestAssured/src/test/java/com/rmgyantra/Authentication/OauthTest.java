package com.rmgyantra.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OauthTest {
  @Test
  public void oauth()
  {
	Response rsps=given()
			.formParam("client_id", "Bala_SDET")
			.formParam("client_secret", "3eaee3e710243d3ed3454b4b4bc952eb")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
			.when()
			.post("http://coop.apps.symfonycasts.com/token");
	        // rsps.prettyPrint();
	        String token=rsps.jsonPath().getString("access_token");
	        System.out.println(token);
	        
	        given()
	        .auth().oauth2(token)
	        .pathParam("USER_ID", "3034")
	        .when()
	        .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
	        .then()
	        .log()
	        .all();
  }
}
