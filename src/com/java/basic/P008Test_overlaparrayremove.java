package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;
import java.util.Vector;

public class P008Test_overlaparrayremove {
	
	

	public static void main(String[] args) throws GeneralException {
		
			String[] overlapStockInDay={"1","1","2","2","3","3","3","1"}; 
			String str=""; 
		
			for(int i=0; i<overlapStockInDay.length; i++){
				
		
				
				for(int j=0; j<overlapStockInDay.length; j++){
					
					if(overlapStockInDay[i].equals(overlapStockInDay[j])){
							str = overlapStockInDay[i]; 
							overlapStockInDay[j]=""; 
							overlapStockInDay[i]=str;  
							
					}
				
				}
					
				
			}
			
			

			for(int a=0; a<overlapStockInDay.length; a++){
				
				if(!overlapStockInDay[a].equals("")){
					System.out.println(overlapStockInDay[a]);
				}
			}
			
			
		
		
	}
	

	

}


