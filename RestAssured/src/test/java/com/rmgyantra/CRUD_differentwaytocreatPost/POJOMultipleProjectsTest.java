package com.rmgyantra.CRUD_differentwaytocreatPost;

import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.POJOClass;

public class POJOMultipleProjectsTest {
   @Test(dataProvider="provideData")
   public void pojoMultipleProjects(String createdBy, String projectName, String status, int teamSize)
   {
	   POJOClass p=new POJOClass( createdBy,  projectName,  status,  teamSize);
		 given()
	     .contentType(ContentType.JSON)
	     .body(p)
	     .when()
	     .post("http://localhost:8084/addProject")
	     .then()
	     .log().all();
   }

   @DataProvider
   public Object[][] provideData()
   {
	   Object[][] obj=new Object[2][4];
	   
	   obj[0][0]="balayesu";
	   obj[0][1]="SDET_Project153";
	   obj[0][2]="created";
	   obj[0][3]=10;
	   
	   obj[1][0]="balayesu";
	   obj[1][1]="SDET_Project456";
	   obj[1][2]="created";
	   obj[1][3]=5;
	   
	   return obj;
   }
}