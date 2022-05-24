package com.rmgyantra.Parameters;

import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;

public class PathParameterTest {
  @Test
  public void pathParameter()
  {
	given()
	.pathParam("proId", "TY_PROJ_1002")
	.when()
	.get("http://localhost:8084/projects/{proId}")
	.then()
	.log()
	.all();
  }
}
