package com.Practies;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PrintAll_ProIDTest {
	@Test
	public void PrintAll_ProID()
	{
		Response rsps=when().get("http://localhost:8084/projects");
		List< String > allData = rsps.jsonPath().getList("projectId");

		for ( String allProId : allData ) 
		{
			System.out.println(allProId);
		}
	}

}
