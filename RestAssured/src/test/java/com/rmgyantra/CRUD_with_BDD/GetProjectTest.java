package com.rmgyantra.CRUD_with_BDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetProjectTest {
	@Test
	public void getproject()
	{
		//first we have to import RestAssured and  make it as a static
		when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
}
