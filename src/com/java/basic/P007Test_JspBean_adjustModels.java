package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Vector;

public class P007Test_JspBean_adjustModels {
	
	

	public static void main(String[] args) throws GeneralException {
		Model[] models = new Model[5]; 
		Model[] updateModels = new Model[models.length]; 
 		models[0] =new Model("정준일",5); //수정 
		models[1] =new Model("정준이",4);//삭제  
		models[2] =new Model("정준삼",5);//수정  
		models[3] =new Model("정준사",2); //추가
		models[4] =new Model("정준육",6); //변화없는 데이터 
		//이런 로우가 있을 것이고.. 
		int totalRow = 0; 
		int totalRowChaged=0; 
		//Vector(a, b);
		//a 개의 데이터를 저장할 수 있는 길이의 객체를 생성한다. 
		//저장곤간이 부족한 경우 b개씩 증가한다. 
		Vector vector = new Vector(2, 2);  //실제로 값이 바뀌거나 추가될 모델 
        Vector vector1 = new Vector(2, 2); //그냥 모델 객체만 넣음 
        
        for(int i=0; i < models.length; i++){ //row수만 큼 반복하면서 
        	
        	 if(models[i].modifiy != 1) //1이 아니면서 
             {
                 if(models[i].getModelStatus() == 2 || models[i].getModelStatus() == 5 || models[i].getModelStatus() == 3 || models[i].getModelStatus() == 6)  //그냥 모델 객체만 넣음     
                	 		//insert ,update				update			    추가 버튼(만) 누른 경우                              		 select
                     vector1.addElement(models[i]); //
                 	System.out.println("vector1" + models[i].getName());
                 if(models[i].getModelStatus() == 2 || models[i].getModelStatus() == 4 || models[i].getModelStatus() == 5)  //실제로 값이 바뀌거나 추가될 모델 
                	 		//insert  ,update    				delete 		    			update 
                     vector.addElement(models[i]);
              	System.out.println("vector" + models[i].getName());
             }
        	    
        	 totalRow = vector1.size(); //안바뀔 객체 
        	 totalRowChaged = vector.size(); //바뀔 객체 
        	
        }
        System.out.println("totalRow=> " + totalRow);
        System.out.println("totalRowChaged=>" + totalRowChaged);
        
        for(int j=0; j<vector.size(); j++){
	        models[j] = (Model)vector.elementAt(j);
	        System.out.println("vector updateModel "+models[j].getName() + " : " +  models[j].getModelStatus());
	        
        }
        for(int k=0; k<vector1.size(); k++){
        	  models[k] = (Model)vector1.elementAt(k);
        	  System.out.println("vector1 Model " +models[k].getName() + " : " + models[k].getModelStatus());
        }


	}
	

	

}


class Model{
	
		private String name="";
		int modifiy = 0; 
		
		public Model(String name,int modifiy){
			
			this.name = name; 
			this.modifiy = modifiy; 
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		} 
		
		public int getModelStatus(){
			
			return modifiy; 
			//2 : insert 
			//3 : ??? (추가만) 
			//4 : 삭제  delete 
			//5 : 수정  update 
			
		}
}



