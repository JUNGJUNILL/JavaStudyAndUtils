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
		
		//Reader , Writer : char ������ ����� 

*/

public class P000_������ {
	
	 public static void visitAllFiles(ArrayList files, File dir) {
	        if(dir.isDirectory()) {
	            File[] children = dir.listFiles();
	            for(File f : children) {
	                // ��� ȣ�� ���
	                // ���� ���� Ž�� �κ�
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
			int osName = osNameTem.indexOf("Windows"); //Windows��� ���ڰ� ������ 0 ������ -1�� ��ȯ�Ѵ�.  
			
			String dirPath="C:\\resin-1.2.10\\doc\\asp\\base\\images\\a9999\\";
			
			System.out.println(osName);
			
			File dir = new File(dirPath);  //�ش� ������ �ִ��� ������ �����ؼ� 
			
			
			if(!(dir.exists())){ //������ �ش� root�� ������ �����Ѵ�. 
				dir.mkdirs();
			}
			
			BufferedWriter bw = null; 
			try{
			FileOutputStream fileoutput = new FileOutputStream(dirPath+"fileList.txt"); 
			//�ش� ��ο� txt������ �����Ѵ�. 
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileoutput); 
			//���� �����͸� ����Ʈ ����� ����� ��Ʈ������ �����ϱ� ���ؼ� ���� ����� ��Ʈ���� ����Ʈ ��Ʈ������ ��ȯ���Ѽ� �����ϴµ� ����Ѵ�. 
			bw= new BufferedWriter(outputStreamWriter); 
	
			
			ArrayList<File> files = new ArrayList<File>();
			
			 visitAllFiles(files, dir);
			 
			 for(File f : files) {
		          String line = f.getName()+"\r\n";
		          bw.write(line);
		      }
		   
			
			}catch(Exception e){
				System.out.println("FileOutputStream=> ���� �߻�" + e);
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
