package outputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

 */
import java.io.OutputStream;

public class FileOutputStream_demo {

	public static void main(String[] args) {

		
		try {
			OutputStream output = new FileOutputStream("c:\\good.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
