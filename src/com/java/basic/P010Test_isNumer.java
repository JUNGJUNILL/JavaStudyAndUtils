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
		
			//���ڿ� ���� ��ȿ�� ���� 
			String str = "����"; 
			if(!isStringDouble(str)){
				System.out.println("���ھƴ�");
			}else{
				System.out.println("������");
			}

		}

	static boolean isStringDouble(String str){
	
			try{
				//������¯
				
				Double.parseDouble(str); 
				return true; 
			}catch(Exception e){
				System.out.println(e);
				return false; 
				
				
			}

	}
}


