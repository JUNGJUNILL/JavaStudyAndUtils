package com.java.basic;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

public class P013Test_DataInputStream_readMethod {

	   public static void main(String[] args) throws IOException {
		      InputStream is = null;
		      DataInputStream dis = null;
		   
		      try {
		         // create input stream from file input stream
		         is = new FileInputStream("c:\\test.txt");
		         
		         // create data input stream
		         dis = new DataInputStream(is);
		         
		         // count the available bytes form the input stream
		         int count = is.available(); //현재 읽을 수 있는 바이트 수를 얻는다.
		         
		         // create buffer
		         byte[] bs = new byte[count];
		         // read data into buffer
		         
		         dis.read(bs);
		         //파일 정보를 byte 단위로 읽기 위함 
		         for(int i=0; i<bs.length; i++){
		        	  System.out.println(dis.read(bs) + "해해"+i);
		        	 System.out.println((char)bs[i]);
		         }
		         
		         //결론적으로 stream data를 자바 자료형으로 읽기 위해서 읽는다.
		   
		         
		         // for each byte in the buffer
		 
		         
		      } catch(Exception e) {
		         // if any I/O error occurs
		         e.printStackTrace();
		      } finally {
		         // releases any associated system files with this stream
		         if(is!=null)
		            is.close();
		         if(dis!=null)
		            dis.close();
		      }   
		   }
		

}

	

