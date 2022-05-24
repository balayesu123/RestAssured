package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GitHubParameterTest {
  @Test
  public void githubParameter()
  {
	  given()
		.pathParam("username", "balayesu123")
		.queryParam("sort", "created")
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.log()
		.all();
  }
}
