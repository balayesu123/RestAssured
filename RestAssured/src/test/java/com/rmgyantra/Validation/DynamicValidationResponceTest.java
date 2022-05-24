package com.rmgyantra.Validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicValidationResponceTest {
  @Test
  public void dynamicValidationResponceTest()
  {
	String expData="sample1111";
	Response rsps=when().get("http://localhost:8084/projects");
	List<String> actData = rsps.jsonPath().getList("projectName");
	 for(String act:actData)
	 {
		 if(act.equals(expData))
		 {
			 System.out.println(expData+"is available");
			 break;
		 }
	 }
  }
}
