package com.rmgyantra.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {
	public Connection con=null;
	public void CreateConnection() throws Throwable
	{
		Driver dref=new Driver(); 
		DriverManager.registerDriver(dref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	}
	public void closeConnectio() throws Throwable
	{
		con.close();
	}
	public ResultSet executeQueryTest(String query) throws Throwable
	{
		Statement stmt = con.createStatement();
		return stmt.executeQuery(query);
	}
}

