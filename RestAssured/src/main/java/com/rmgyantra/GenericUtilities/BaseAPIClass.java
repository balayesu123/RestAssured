package com.rmgyantra.GenericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {
  public DataBaseUtility dUtil=new DataBaseUtility();
  @BeforeSuite
  public void conDatabase() throws Throwable
  {
	  dUtil.CreateConnection();
  }
  @AfterSuite
  public void closeDatabase() throws Throwable
  {
	  dUtil.closeConnectio(); 
  }
}
