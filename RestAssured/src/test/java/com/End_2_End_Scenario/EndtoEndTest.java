package com.End_2_End_Scenario;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.ResultSet;

import org.testng.annotations.Test;

import com.rmgyantra.GenericUtilities.BaseAPIClass;
import com.rmgyantra.GenericUtilities.EndPoints;
import com.rmgyantra.GenericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.POJOClass;

public class EndtoEndTest extends BaseAPIClass implements EndPoints
{
	@Test
	public void endToend() throws Throwable
	{
		JavaUtility jUtil=new JavaUtility();
		baseURI="http://localhost";
		port=8084;
		POJOClass pc=new POJOClass("balayesu","SDET_5PRO"+jUtil.genarateRandamNumber(),"created",5);

		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(pc)
				.when()
				.post(EndPoints.createProject);

		String proId=rsps.jsonPath().get("projectId");

		Response rsps1 = given()
				.pathParam("projectid",proId)
				.when()
				.get("/projects/{projectid}");

		String proName=rsps1.jsonPath().get("projectName");

		ResultSet result = dUtil.executeQueryTest("select * from project;");
		while(result.next())
		{
			String projectname=result.getString(4);
			//System.out.println(projectname);
			if(projectname.equals(proName))
			{
				System.out.println(proName+" is available in Database");

			}


		}
	}
}
