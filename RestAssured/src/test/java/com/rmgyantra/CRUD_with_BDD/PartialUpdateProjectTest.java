package com.rmgyantra.CRUD_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PartialUpdateProjectTest {
  @Test
  public void partialupdate()
  {
	  JSONObject jobj=new JSONObject();
	   jobj.put("name","Bala126");
	   jobj.put("projectName", "SDET-withBDD-Partialupdate");
	    
	   given()
	       .contentType(ContentType.JSON)
	       .body(jobj)
	       .when()
	       .patch("https://reqres.in/api/users/2")
	       .then()
	       .assertThat().statusCode(200)
	       .and()
	       .assertThat().contentType(ContentType.JSON)
	       .log().all();
  }
}
