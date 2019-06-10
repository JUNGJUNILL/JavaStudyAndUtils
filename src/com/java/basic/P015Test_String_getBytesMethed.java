package com.java.basic;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class P015Test_String_getBytesMethed {
	


	   public static void main(String[] args) throws GeneralException,FileNotFoundException, IOException {
	
		   
		   
		   String test="정 "; 
		   
		   byte[] a = test.trim().getBytes(); 
		  
		   byte[] b = {45};
		   String str2 = new String(b); 
		   System.out.println("str2--dd>"+str2);
 		   
		   
		   String str = "한글";
		   byte[] array1 = str.getBytes();
		   for(int i=0; i<a.length; i++){
			   System.out.println(array1[i]);
		   }
         String str1  = new String(array1); 
         System.out.println(str1);
        
         //String getBytes()는 자바 내부에서 관리되는 유니코드 문자열을 인자로 지정된 캐릭터 셋의 바이트 배열로 반환하는 메서드이다
		   
		   String str11="\"정준일\""; 
		
		   try {
			trimParam(str11);
			 System.out.println( trimParam(str11));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
	}
	   public static String trimParam(String s) throws Exception{
			
			
			if(s == null){
		        return null;
			}
		    byte abyte0[] = s.trim().getBytes();
		    
		    if(abyte0.length == 0){
		        return null;
		    }
		    
		    
		    if(abyte0[0] == 34){ //34는 " 이므로 공백처리를 해준다... 
		        abyte0[0] = 32;
		    }
		    
		    if(abyte0[abyte0.length - 1] == 34){
		        abyte0[abyte0.length - 1] = 32;
		    }
		    
		    String s1 = (new String(abyte0)).trim();

		    if(s1 != null && s1.length() == 0)
		        s1 = null;
		    return s1;
		}

}


