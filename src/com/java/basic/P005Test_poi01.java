package com.java.basic;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.modelmbean.ModelMBean;

import org.apache.poi.ss.formula.functions.Mode;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class P005Test_poi01 {

	public static void main(String[] args) {
		
	FileInputStream fis =  null; 
	int rowIndex ; 
	int columnIndex; 
	int[] sheetNum=null; 
	XSSFSheet sheet = null;
	int rowCount= 0; 

	
	ArrayList<String> colnumnNames = new ArrayList<String>(); 
	ArrayList<EmpModel> resultRowsData =new  ArrayList<EmpModel>(); 
	ArrayList<ArrayList<String>> resultDataArr = new ArrayList<ArrayList<String>>();
	EmpModel model=null; 
	EmpModel[] models=null; 
//	XSSFCell[] cells = null; 

	try{
		
		 fis =new FileInputStream(new File("C://poiJartest.xlsx"));  //���� �����ͼ� 
		 
		 
		XSSFWorkbook workdBook = new XSSFWorkbook(fis);  //���� ��ü ����
		sheet =workdBook.getSheetAt(0); //ù��° ��Ʈ...   
		int sheetCount = workdBook.getNumberOfSheets(); //��Ʈ ���� ������ 
			
			
		rowCount = sheet.getPhysicalNumberOfRows(); 
		
		//Iterator test   = sheet.rowIterator(); 
	
				
		for(rowIndex=1; rowIndex<rowCount; rowIndex++){ //ù��° row�� �÷����̱� ������... 
				   //�� ������ � row���� �����ͷ� ���� ���ΰ�? 
			
			XSSFRow  row = sheet.getRow(rowIndex); //�ش� row �� ���� ���̴�. 
			int column = row.getPhysicalNumberOfCells(); //�÷� ���� 
			
			XSSFCell[] cells = new XSSFCell[column]; 
			
			for(columnIndex=0; columnIndex<column; columnIndex++){
				
				cells[columnIndex] = row.getCell(columnIndex); 
			}
			
			System.out.println(	cells[0].getStringCellValue()+" : "+cells[1].getStringCellValue()+" : "+cells[2].getStringCellValue()+" : "+cells[3].getStringCellValue()+" : "+cells[4].getStringCellValue()+" : "+cells[5].getStringCellValue()+" : "+cells[6].getStringCellValue()+" : "+cells[7].getStringCellValue()+" : "+cells[8].getStringCellValue());
			
			
			
		

			
		}
		
		
	}catch(Exception e){
		System.out.println(e);
	}
		

	}

}
