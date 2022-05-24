package com.rmgyantra.CRUD_with_BDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CompleatUpdateProjectTest {
   @Test
   public void compleatUpdate()
   {
	   JSONObject jobj=new JSONObject();
	   jobj.put("createdBy","Balayesu596");
	   jobj.put("projectName", "SDET-withBDDcompteateupdate");
	   jobj.put("status", "created-updated");
	   jobj.put("teamSize", 5);
	    
	   given()
	       .contentType(ContentType.JSON)
	       .body(jobj)
	       .when()
	       .put("http://localhost:8084/projects/TY_PROJ_1802")
	       .then()
	       .assertThat().statusCode(200)
	       .and()
	       .assertThat().contentType(ContentType.JSON)
	       .log().all();
   }
}
