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
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class P000_연습장4 {


	   public static void main(String[] args) throws GeneralException,FileNotFoundException, IOException {
		   FileNameParse fnp = new FileNameParse(); 
		   InputStream  fis= null;
		   
		   String[] fileRoot=  fnp.saveFilePathName();
		   File uploadFile =new File(fileRoot[0]+"fileList.txt"); 
		  
		   fis =  new FileInputStream(uploadFile);
		   DataInputStream dataInputStream = new DataInputStream(fis);

		try {
			   
			MultiPartParser fileUploadParser = new MultiPartParser(dataInputStream,fnp.saveFilePathName());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		   
		  
		 
		   
		
	
		   
	}
}




class MultiPartParser{

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
     boolean isFileNameOnly;
     
     public MultiPartParser(DataInputStream httpservletrequest, String as[]) throws Exception{
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
         getRequest(httpservletrequest);
    	 
     }
	
    public void getRequest(DataInputStream dataInputStream) throws Exception{
    	 servletIn = new DataInputStream(dataInputStream);

    	 makeParameters();
    }
    
    //루트 검증 하는 작업
    public void setTargetDir(String as[]) throws Exception{
    	
    	   for(int i = 0; i < as.length; i++)
               if(as == null || !(new File(as[i])).isDirectory())
                   throw new Exception("invalid Directory");

           targetDir = as;
    }
    
    
    public void  makeParameters() throws Exception{
    	if(servletIn.read(delimiter) != delimiter.length){
    		return; 
    	}
    	
    	
    	while(!endOfFile){
    		
    		System.out.println("endOfFile while");
    		
    	    parmName = null; //String
            parmValue = null; //String
            saveFile = null; //File
    		
            
            try{
            	
      
            	while(servletIn.readByte() != 10);  //10은 공백, 공백이 나올 때 까지 계속 돌다가...
            	getParmName(); //parmName변수에 넣을 값 리턴 해주는 함수 
            	  
            	if(oneByte == 10){
            		 while(servletIn.readByte() != 10);
            		 getParmValue();
            		 
            	}else if(oneByte == 59){
            		
            		 servletIn.readByte();
            	}
            	
            	
            }catch(EOFException eofexception){eofexception.printStackTrace();
            
            endOfFile = true;
            }
            
           
    		
    	}

    }
    
    
    
    public void getParmName() throws Exception{
    	System.out.println("getParmName()");
    	byte abyte0[] = new byte[100];
    	while(servletIn.readByte() != 61); //servletIn.readByte()가 61이 될 때까지 반복한다.
    									    //61이 되면 반복문을 멈춘다. 
    										//  61은 =(특수문자이다)
    	int i=0; 
    	
    	do{
    		
    		oneByte = servletIn.readByte(); 
  
    		if(oneByte != 10 && oneByte !=59){  
    			//oneByte가 10이 아니면서 59도 아닌 경우...
    			//공백 또는 ; 인 경우
    			
    			  abyte0[i] = oneByte;
    			  System.out.println("oneByte-->" +   oneByte + "    abyte[i]-->" +   abyte0[i]);
                  i++;
                  
                  if(oneByte == 10 && oneByte ==59){
                	  System.out.println("true" + oneByte);
                  }
                 
                
    		}else{
    	
    		     parmName = trimParm(new String(abyte0, 0, i));
    		     System.out.println("parmName->"  + parmName +":###" +oneByte);
                 return; //do while을 떠나서 함수이므로 종료를 시키는구나.
    		}
    		System.out.println("getParmName()----------do");
    		
    	}while(true);
    	
    
    	 
    }
    
    
    //이 함수는 결론적으로 
    //"정준일" ->  정준일 로 반환해주는 함수이다. 
    public String trimParm(String s) throws Exception{
    	
    	
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
    
    
    
    
    public void getParmValue()throws Exception{
    	System.out.println("getParmValue()");
    	
    	   byte abyte0[] = new byte[204800]; //25MB
           int i = 0;
           
           do
           {
        	   
        	   oneByte = servletIn.readByte();
        	   if(oneByte == 45){ //특수문자 - 이다. 
        		 
        		   
        		      if(!isDelimiter(oneByte)){
                         
        		    	  for(int j = 0; j < leadBufferLength; j++){
                              
        		    		  abyte0[i] = leadBuffer[j];
                              i++;
                          }

                      }else{
                    	  
                          parmValue = trimParm(new String(abyte0, 0, i));
                          return;
                          
                      }
        		   
        	   }else{
        		   
        		   abyte0[i] = oneByte;
                   i++;
        		   
        	   }
        	   
        	   
        	   
           }while(true);
    	
    	
    	
    }
    
    
    public boolean isDelimiter(byte byte0)  throws Exception{
    	
    	
    	  	leadBufferLength = 0;
	        leadBuffer[leadBufferLength] = byte0; //byte[]
	        leadBufferLength++;
	        
	        do{
	        	
	        	   oneByte = servletIn.readByte();
	               leadBuffer[leadBufferLength] = oneByte;
	               leadBufferLength++;
	               if(compareBytes(contentType, leadBuffer, leadBufferLength))
	               {
	                   if(leadBufferLength == contentType.length)
	                       return true;
	               } else
	               {
	                   return false;
	               }
	        	
	        }while(true); 
    	
    }
    
    
   public boolean compareBytes(byte abyte0[], byte abyte1[], int i)throws Exception{ 
    	
	   if(abyte0 == null || abyte1 == null) return false;

       if(abyte0.length < i || abyte1.length < i) return false;
       
       for(int j = 0; j < i; j++){   	   
           if(abyte0[j] != abyte1[j])  return false;              
       }
       
       return true;
	   
    }
    
    
}

	





class FileNameParse{
	
	
	public String[] saveFilePathName() throws GeneralException,FileNotFoundException, IOException{
		System.out.println("------------------------------------------ saveFilePathName() 시작");
		String[] saveFilePath = new String[1];
		
		String osNameTmp=System.getProperty("os.name");
		int osName=osNameTmp.indexOf("Windows");
		String dirPath=null;
		if(osName==-1){// 		//Unix(Solaris)Server:
			dirPath ="/usr/local/resin/resin-1.2.10/doc/asp/base/files/";//--unix
		}else{ 		//Windows(2000)Server:
			//dirPath="C:\\resin-1.2.10\\doc\\asp\\base\\files\\";
			dirPath="C:\\resin-1.2.10\\doc\\asp\\base\\images\\a8888\\";
		}
		
		
		File dir = new File(dirPath); 
		if(!dir.exists()){ //해당 루트의 폴더가 존재하지 않으면  
			
			dir.mkdirs(); //해당 루트에 그 폴더를 만들어라
			
		}
		
		saveFilePath[0] = dirPath; //저장할 폴더 경로 지정... 
		
		fileNameList(dirPath,dir);
		
		return saveFilePath;
		
		
	}
	
	
	 public void fileNameList(String dirPath,File dir) throws FileNotFoundException, IOException{
		 System.out.println("------------------------------------------ fileNameList(String dirPath,File dir) 시작");
	
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dirPath+"fileList.txt")));
		 																	//해당 루트에 fileList.txt 파일을 생성하여 
		 										//byte단위의 데이터를 char 데이터로 활용할 수 있게 연결? 한다. (정확하지는 않음)
		 
		 /*
			Reader
				-BufferedReader 
				-InputStreamReader - FileReader 
				
			Writer
				-BufferedWriter 
				-OutputStreamWriter -FileWriter 
				
				Stream 			: 바이트 단위의 입출력
				Reader , Writer : char 단위의 입출력 
	
		*/
		 ArrayList<File> files = new ArrayList<File>();
		 
	      visitAllFiles(files, dir);
	        // 탐색한 파일을 하나씩 출력할 파일에 쓴다.
	        for(File f : files) {
	            String line = f.getName()+"\r\n";
	            bw.write(line);
	        }
	        
	        //------------
	        bw.flush(); // 남아있는 데이터를 모두 출력시킴 
	        bw.close(); // 스트림 닫음
	        //------------ BufferedWriter의 경우 버퍼를 잡아 놓았기 때문에 반드시 호출해 주어야 한다.
	 
	 }
	 
	 
	 public void visitAllFiles(ArrayList files, File dir) {
		 System.out.println("------------------------------------------ visitAllFiles(ArrayList files, File dir) 시작");
		 if(dir.isDirectory()){ //해당 루트가 폴더냐 아니냐를 검증하는 작업 
			 					//해당 dir은 폴더이므로 true 
			 
			 File[] children = dir.listFiles(); //해당 dir의 파일 전체를 File 배열에 담는다. 
			
			 for(File f : children){ 

				 visitAllFiles(files,f);//재귀 호출 사용 
			 
			 }
			 
		 }else{
			 
			 files.add(dir); //해당 루트가 폴더가 아니면 
		 }
		 
	 }
	 
	
	 
	 
	 
}

