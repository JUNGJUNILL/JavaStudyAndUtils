package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class P002Test_properties {
 
	
	Properties prop1=new Properties();
	Properties prop2=new Properties();
	
	
	void setFilterProperties(Properties p){
		Enumeration e = p.propertyNames(); 
		String param=""; 
		
		prop2.setProperty("A","--");
		prop2.setProperty("B","group by");
		prop2.setProperty("C","\'"); // '
		prop2.setProperty("D","\""); // "
		prop2.setProperty("E","'");
		
		while(e.hasMoreElements()){
			
			param = p.getProperty((String)e.nextElement()); 
			
		}
		
	}
	
	
	
	
	public static void main(String[] args) {

		
		
	}
	

}
