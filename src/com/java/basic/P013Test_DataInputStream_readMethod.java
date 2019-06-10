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
		         int count = is.available(); //���� ���� �� �ִ� ����Ʈ ���� ��´�.
		         
		         // create buffer
		         byte[] bs = new byte[count];
		         // read data into buffer
		         
		         dis.read(bs);
		         //���� ������ byte ������ �б� ���� 
		         for(int i=0; i<bs.length; i++){
		        	  System.out.println(dis.read(bs) + "����"+i);
		        	 System.out.println((char)bs[i]);
		         }
		         
		         //��������� stream data�� �ڹ� �ڷ������� �б� ���ؼ� �д´�.
		   
		         
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

	

