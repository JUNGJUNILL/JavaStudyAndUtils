package com.java.basic;

import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import net.mtn.common.Converter;


/*
	Reader
		-BufferedReader 
		-InputStreamReader - FileReader 
		
	Writer
		-BufferedWriter 
		-OutputStreamWriter -FileWriter 
		
		//Reader , Writer : char 단위의 입출력 

*/

public class P000_연습장 {
	
	 public static void visitAllFiles(ArrayList files, File dir) {
	        if(dir.isDirectory()) {
	            File[] children = dir.listFiles();
	            for(File f : children) {
	                // 재귀 호출 사용
	                // 하위 폴더 탐색 부분
	            	System.out.println(f.getName());
	                visitAllFiles(files,f);
	            }
	        } else {
	            files.add(dir);
	        }
	    }
	
	public static void main(String[] args) {
			String[] saveFilePath = new String[1];
			String osNameTem = System.getProperty("os.name"); 
			System.out.println(osNameTem);
			int osName = osNameTem.indexOf("Windows"); //Windows라는 글자가 있으면 0 없으면 -1을 반환한다.  
			
			String dirPath="C:\\resin-1.2.10\\doc\\asp\\base\\images\\a9999\\";
			
			System.out.println(osName);
			
			File dir = new File(dirPath);  //해당 폴더가 있는지 없는지 검증해서 
			
			
			if(!(dir.exists())){ //없으면 해당 root에 폴더를 생성한다. 
				dir.mkdirs();
			}
			
			BufferedWriter bw = null; 
			try{
			FileOutputStream fileoutput = new FileOutputStream(dirPath+"fileList.txt"); 
			//해당 경로에 txt파일을 생성한다. 
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileoutput); 
			//문자 데이터를 바이트 기반의 입출력 스트림으로 전송하기 위해서 문자 입출력 스트림을 바이트 스트림으로 변환시켜서 전송하는데 사용한다. 
			bw= new BufferedWriter(outputStreamWriter); 
	
			
			ArrayList<File> files = new ArrayList<File>();
			
			 visitAllFiles(files, dir);
			 
			 for(File f : files) {
		          String line = f.getName()+"\r\n";
		          bw.write(line);
		      }
		   
			
			}catch(Exception e){
				System.out.println("FileOutputStream=> 에러 발생" + e);
			}finally{
				
				try{
					bw.flush();
					bw.close();					
				}catch(Exception e){}

				
			}
			
			
			saveFilePath[0]=dirPath;
			
			System.out.println(saveFilePath[0].toString());
			
			
			
	}

}
