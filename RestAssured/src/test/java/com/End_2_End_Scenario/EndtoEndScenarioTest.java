package com.End_2_End_Scenario;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgyantra.GenericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.POJOClass;

public class EndtoEndScenarioTest {
	@Test
	public void endToendScenario() throws Throwable 
	{
		JavaUtility jUtil=new JavaUtility();
		baseURI="http://localhost";
		port=8084;

		//	   JSONObject jobj=new JSONObject();
		//	   jobj.put("createdBy","Balayesu");
		//	   jobj.put("projectName", "SDET-5Project19"+jUtil.genarateUtiliy());
		//	   jobj.put("status", "created");
		//	   jobj.put("teamSize", 5);

		POJOClass pc=new POJOClass("balayesu","SDET_5PRO"+jUtil.genarateRandamNumber(),"created",5);

		Response rsps = given()
				.contentType(ContentType.JSON)
				.body(pc)
				.when()	      
				.post("/addProject");
		//rsps.prettyPrint();

		String projectid=rsps.jsonPath().get("projectId");

		Response rsps1 = given()
				.pathParam("proId",projectid)
				.when()
				.get("/projects/{proId}");
		//rsps1.prettyPrint();

		String projectname=rsps1.jsonPath().get("projectName");
		System.out.println(projectname);

		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("select * from project");
		while(result.next())
		{
			String proNm=result.getString(4);
			if(proNm.equals(projectname))
			{
				System.out.println(projectname+" is present");
			}
			con.close();
		}


	}
}
