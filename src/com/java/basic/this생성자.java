package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class this»ý¼ºÀÚ {

	public static void main(String[] args) throws GeneralException {

		
		String test = "test"; 
		if(!(test.equals("111"))){
				throw new GeneralException("ERROR-2XX- bad value : [and,or] "); 
		}
		
	}
	

	

}

class GeneralException extends Exception{
	
		
	public GeneralException(String s){
		super(s); 
	}
	
	public GeneralException(){
		
		this("ERROR-110"); 
	}
	
}