package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class P001Test_properties {

	public static void main(String[] args) {

		
	//key <-> value 구조의 데이터를 가져온다. 
	Properties prop = new Properties(); 
	FileInputStream fis = null; 
	
	String fileNmae ="C:\\propertiesTest\\test.properties"; 
	
	try{
		fis = new FileInputStream(fileNmae); 
		prop.load(fis);
		
	}catch(Exception e){
		System.out.println(e);

	}finally{
		if(fis !=null){
			try{
				
			}catch(Exception e){
				System.out.println(e);

			}
		}
	}
	
	
	String id = prop.getProperty("hello");
	System.out.println(id);
	Enumeration e =prop.propertyNames() ; 
	while(e.hasMoreElements()){
		System.out.println("test")
		;
	}
	System.out.println(prop.propertyNames());
	
	
	
	
	
	
		
	}

}
