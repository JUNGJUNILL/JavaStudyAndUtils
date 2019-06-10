package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class P003Test_properties {

	public static void main(String[] args) {

		
		
		  Properties prop = new Properties();

	      // add some properties
	      prop.put("Height", "200");
	      prop.put("Width", "15");

	      // assign the property names in a enumaration
	      Enumeration<?> enumeration = prop.propertyNames();

	      
	    
	      /*
	       Tests if this enumeration co
	       ntains more elements.
Returns:true if and only if this enumeration object contains at least one more element to provide; false otherwise.

*/
	      // print the enumaration elements
	      System.out.println("" + enumeration.nextElement());
	   
	      
	      

	      System.out.println("\'");
	      System.out.println("\"");
	   
	      
		
		
	}
	

	

}
