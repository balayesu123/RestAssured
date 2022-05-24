package com.rmgyantra.GenericUtilities;

import java.util.Random;

public class JavaUtility {
  
	public int genarateRandamNumber()
	{
		Random r=new Random();
		int rm=r.nextInt(1000);
		return rm;
}
}
