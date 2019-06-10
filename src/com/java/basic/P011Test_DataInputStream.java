package com.java.basic;

/*
 	InputStream
 		-FileInputStream 
 		-FiterInputStream
 			-BufferedInpuStream 
 			-*DataInputStream 
	
	OutputStream 
		-FileOutputStream 
 		-FileOutputStream
 			-BufferedOutpuStream 
 			-*DataOutputStream 

	DataInputStream과 
	DataOutputStream은 자바의 기본 자료형 데이터를 바이트 스트림으로 입출력하는 기능을 제공하는 ByteStream 클래스이다. 

	DataInputStream과 DataOutputStream 은 FilterInputStream과 FilterOutputStream을 상속하고 있어, 
	객체 생성시에 InputStream과 OutputStream을 매개변수 인자로 가진다.

	FileInputStream / FileOutputStream 과의 차이점은 자바 기본 자료형 데이터를 입/출력 할 수 있다는 것이다.
	FileInputStream / FileOutputStream 은 byte[] 단위의 데이터만 입/출력을 할 수 있었다.
	
	하지만 DataStream Filter를 적용함으로써, 자바 기본 자료형(char, int, long, ...) 으로 데이터를 입력하고 출력할 수 있다.
	출처: https://hyeonstorage.tistory.com/239 [개발이 하고 싶어요]

*/

import java.awt.Point;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class P011Test_DataInputStream {
	

	 long maxLength = 0;
     Vector parameters;
     DataInputStream servletIn;
     FileOutputStream fileOut;
     final int fileBufferMax = 1024;
     final int fileBufferMin = 64;
     byte fileBuffer[];
     int fileBufferLength;
     boolean endOfFile;
     int leadBufferLength;
     byte leadBuffer[];
     byte delimiter[];
     byte nameHeader[];
     byte contentType[];
     byte oneByte;
     final byte NEWLINE = 10;
     final byte CR = 13;
     final byte DASH = 45;
     final byte EQUAL = 61;
     final byte SPACE = 32;
     final byte SEMICOLON = 59;
     final byte DOUBLEQUOTE = 34;
     String targetDir[];
     int currPosition;
     String parmName;
     String parmValue;
     File saveFile;
     boolean isFileNameOnly = true;


	private static void MultiPartParser(File file, String[] as){
		
			parameters = new Vector();
	        servletIn = null;
	        fileOut = null;
	        fileBuffer = new byte[1024];
	        fileBufferLength = 0;
	        endOfFile = false;
	        leadBufferLength = 0;
	        leadBuffer = new byte[100];
	        delimiter = new byte[35];
	        nameHeader = (new String("Content-Disposition: form-data; name=")).getBytes();
	        contentType = (new String("Content-Type: ")).getBytes();
	        oneByte = 0;
	        currPosition = 0;
	        isFileNameOnly = true;
	        setTargetDir(as);
	        getRequest(httpservletrequest);
	
	}
	public static void main(String[] args) throws GeneralException, EOFException,IOException {
	
			
			
		
		
//---------------------------------------------------------------
		

	        
	        
//-----------------------------------------------         setTargetDir(as); start
	        String[] as = new String[1]; 
	        as[0]  = "C:\\resin-1.2.10\\doc\\asp\\base\\images\\a9999\\"; 
	        		
	        
	        for(int i=0; i< as.length; i++ ){
	        	if(as == null || !(new File(as[i])).isDirectory()){
	        				
	        		 try{
	        			System.out.println("여기나오면 안되  : 유효한 폴더가 아닙니다. ");
	        			 
	        		 }catch(Exception e){
	        			 System.out.println(e);
	        		 }
	        	}
	        }
	        
	        targetDir = as; 
//-----------------------------------------------          setTargetDir(as); end	        
	        FileInputStream  fis= null;
	        File uploadFile =new File(as[0] + "pictureTest.jpg");
	        //File uploadFile =new File("c:\\test.txt");
	        try{
	        fis  =new FileInputStream(uploadFile); 
	        }catch(IOException e){
	        	System.out.println("115 line 에러발생"+ e);
	        }
//-----------------------------------------------           getRequest(httpservletrequest); start	        
	        servletIn = new DataInputStream(fis);
//-----------------------------------------------           getRequest(httpservletrequest); end 
	        
//-----------------------------------------------           makeParameters(); start	 	        
	    	try {
				System.out.println(servletIn.read(delimiter));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try{
	        	
		        if(servletIn.read(delimiter) != delimiter.length) return; 
		        
		           
		        
		        }catch(IOException io){System.out.println("io에러 131 line" + io);} 
	        
	        
	        while(!endOfFile){

	        	
	        	 parmName = null; //String
	             parmValue = null;//String
	             saveFile = null; //File
	        	
	             
	             while(servletIn.readByte() != 10) ; //10이 될 때까지 돈다.. 
	             
	             byte abyte0[] = new byte[100];
	             while(servletIn.readByte() != 61) ;
	             int i = 0;
	             do
	             {
	                 oneByte = servletIn.readByte();
	                 if(oneByte != 10 && oneByte != 59)
	                 {
	                     abyte0[i] = oneByte;
	                     i++;
	                 } else
	                 {
	                     parmName = trimParm(new String(abyte0, 0, i));
	                     return;
	                 }
	             } while(true);
	         }
	             
	        }
	        
//-----------------------------------------------           makeParameters(); end	 
	        
	      
	}
}


