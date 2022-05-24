package com.rmgyantra.CRUD_Without_BDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeletingTheProjectTest {
   @Test
   public void deletingTheProject()
   {
	  Response rsps = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1004");
	  ValidatableResponse vres = rsps.then();
	  vres.assertThat().statusCode(204);
	  vres.log().all();
	   
   }

}
