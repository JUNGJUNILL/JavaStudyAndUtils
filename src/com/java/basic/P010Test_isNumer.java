package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class P010Test_isNumer {

	public static void main(String[] args) throws GeneralException {
		
			//문자열 숫자 유효성 검증 
			String str = "준일"; 
			if(!isStringDouble(str)){
				System.out.println("숫자아님");
			}else{
				System.out.println("숫자임");
			}

		}

	static boolean isStringDouble(String str){
	
			try{
				//정준일짱
				
				Double.parseDouble(str); 
				return true; 
			}catch(Exception e){
				System.out.println(e);
				return false; 
				
				
			}

	}
}


