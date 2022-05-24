package com.Practies;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostReuestTest {
	@Test
	public void post() {

		 JSONObject jobj=new JSONObject();
		   jobj.put("Employe","Balayesu");
		   jobj.put("Id", "1234");
		    
		   given()
		       .contentType(ContentType.JSON)
		       .body(jobj)
		       .when()
		       .post("http://localhost:8084/addProject")
		       .then()
		       .assertThat().statusCode(201)
		       .and()
		       .assertThat().contentType(ContentType.JSON)
		       .log().all();
	}

}
