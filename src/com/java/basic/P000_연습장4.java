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

public class P000_������4 {


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
    
    //��Ʈ ���� �ϴ� �۾�
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
            	
      
            	while(servletIn.readByte() != 10);  //10�� ����, ������ ���� �� ���� ��� ���ٰ�...
            	getParmName(); //parmName������ ���� �� ���� ���ִ� �Լ� 
            	  
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
    	while(servletIn.readByte() != 61); //servletIn.readByte()�� 61�� �� ������ �ݺ��Ѵ�.
    									    //61�� �Ǹ� �ݺ����� �����. 
    										//  61�� =(Ư�������̴�)
    	int i=0; 
    	
    	do{
    		
    		oneByte = servletIn.readByte(); 
  
    		if(oneByte != 10 && oneByte !=59){  
    			//oneByte�� 10�� �ƴϸ鼭 59�� �ƴ� ���...
    			//���� �Ǵ� ; �� ���
    			
    			  abyte0[i] = oneByte;
    			  System.out.println("oneByte-->" +   oneByte + "    abyte[i]-->" +   abyte0[i]);
                  i++;
                  
                  if(oneByte == 10 && oneByte ==59){
                	  System.out.println("true" + oneByte);
                  }
                 
                
    		}else{
    	
    		     parmName = trimParm(new String(abyte0, 0, i));
    		     System.out.println("parmName->"  + parmName +":###" +oneByte);
                 return; //do while�� ������ �Լ��̹Ƿ� ���Ḧ ��Ű�±���.
    		}
    		System.out.println("getParmName()----------do");
    		
    	}while(true);
    	
    
    	 
    }
    
    
    //�� �Լ��� ��������� 
    //"������" ->  ������ �� ��ȯ���ִ� �Լ��̴�. 
    public String trimParm(String s) throws Exception{
    	
    	
    	if(s == null){
            return null;
    	}
        byte abyte0[] = s.trim().getBytes();
        
        if(abyte0.length == 0){
            return null;
        }
        
        
        if(abyte0[0] == 34){ //34�� " �̹Ƿ� ����ó���� ���ش�... 
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
        	   if(oneByte == 45){ //Ư������ - �̴�. 
        		 
        		   
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
		System.out.println("------------------------------------------ saveFilePathName() ����");
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
		if(!dir.exists()){ //�ش� ��Ʈ�� ������ �������� ������  
			
			dir.mkdirs(); //�ش� ��Ʈ�� �� ������ ������
			
		}
		
		saveFilePath[0] = dirPath; //������ ���� ��� ����... 
		
		fileNameList(dirPath,dir);
		
		return saveFilePath;
		
		
	}
	
	
	 public void fileNameList(String dirPath,File dir) throws FileNotFoundException, IOException{
		 System.out.println("------------------------------------------ fileNameList(String dirPath,File dir) ����");
	
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dirPath+"fileList.txt")));
		 																	//�ش� ��Ʈ�� fileList.txt ������ �����Ͽ� 
		 										//byte������ �����͸� char �����ͷ� Ȱ���� �� �ְ� ����? �Ѵ�. (��Ȯ������ ����)
		 
		 /*
			Reader
				-BufferedReader 
				-InputStreamReader - FileReader 
				
			Writer
				-BufferedWriter 
				-OutputStreamWriter -FileWriter 
				
				Stream 			: ����Ʈ ������ �����
				Reader , Writer : char ������ ����� 
	
		*/
		 ArrayList<File> files = new ArrayList<File>();
		 
	      visitAllFiles(files, dir);
	        // Ž���� ������ �ϳ��� ����� ���Ͽ� ����.
	        for(File f : files) {
	            String line = f.getName()+"\r\n";
	            bw.write(line);
	        }
	        
	        //------------
	        bw.flush(); // �����ִ� �����͸� ��� ��½�Ŵ 
	        bw.close(); // ��Ʈ�� ����
	        //------------ BufferedWriter�� ��� ���۸� ��� ���ұ� ������ �ݵ�� ȣ���� �־�� �Ѵ�.
	 
	 }
	 
	 
	 public void visitAllFiles(ArrayList files, File dir) {
		 System.out.println("------------------------------------------ visitAllFiles(ArrayList files, File dir) ����");
		 if(dir.isDirectory()){ //�ش� ��Ʈ�� ������ �ƴϳĸ� �����ϴ� �۾� 
			 					//�ش� dir�� �����̹Ƿ� true 
			 
			 File[] children = dir.listFiles(); //�ش� dir�� ���� ��ü�� File �迭�� ��´�. 
			
			 for(File f : children){ 

				 visitAllFiles(files,f);//��� ȣ�� ��� 
			 
			 }
			 
		 }else{
			 
			 files.add(dir); //�ش� ��Ʈ�� ������ �ƴϸ� 
		 }
		 
	 }
	 
	
	 
	 
	 
}

