package com.rmgyantra.CRUD_with_BDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DeleteProjectTest {
   @Test
   public void deleteProject()
   {
	   when()
	     .delete("http://localhost:8084/projects/TY_PROJ_22011")
        .then()
         .assertThat().statusCode(204)
         .log().all();
     
   }
}
