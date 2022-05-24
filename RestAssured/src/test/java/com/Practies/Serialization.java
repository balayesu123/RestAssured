package com.Practies;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoLibrary.POJOClass;

public class Serialization {
	
	@Test

	 public void serialization() throws Exception, JsonMappingException, IOException {
		 POJOClass p=new POJOClass("Blayesu","SDET-Serialization","ctreated",5);
		
		 ObjectMapper objm = new ObjectMapper();
	 objm.writeValue(new File("./jsonBody1.jason"), p);
	 
	 
	 
	
		
	  }
}
