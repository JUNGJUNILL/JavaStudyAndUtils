package com.java.basic;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

public class P014Test_DataInputStream_readByteMethod {

	   public static void main(String[] args) throws IOException {
		    
		   InputStream is = null; 
		   DataInputStream dis = null; 
		   byte[] buf = {65,0,0,68,69}; 
		   File uploadFile =new File("C:\\resin-1.2.10\\doc\\asp\\base\\images\\a8888\\pictureTest.jpg"); 
		   try{
			   
			  is = new ByteArrayInputStream(buf); 
			 // is = new FileInputStream(uploadFile);
			   dis = new DataInputStream(is); 


			   	System.out.println("dis.available()-->" + dis.available());
			   	//����Ʈ �迭�� ������ ��ȯ�Ѵ�. 
			   	System.out.println("------------------------------------");
			   	System.out.println(dis.readByte() + " : "  + dis.available());
			 	System.out.println("------------------------------------");
			   while(dis.available()> 0){
				   
				
				   byte b = dis.readByte(); 
				   //DataInputStream�� byte�迭�� �޾Ƽ� 
				   //�� �迭�� ��Ҹ� ����ϴ� �����̴�.
				   
				   
				   System.out.println(b);
			   }
			     
		
			   
			   
			   
		   }catch(Exception e){
			   
			   	System.out.println(e);
		   
		   }  finally {
		         // releases any associated system files with this stream
		         if(is!=null)
		            is.close();
		         if(dis!=null)
		            dis.close();
		      }   
		   
		   
		   
		   
	   }

}

	

