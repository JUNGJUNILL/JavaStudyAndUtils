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
 		models[0] =new Model("������",5); //���� 
		models[1] =new Model("������",4);//����  
		models[2] =new Model("���ػ�",5);//����  
		models[3] =new Model("���ػ�",2); //�߰�
		models[4] =new Model("������",6); //��ȭ���� ������ 
		//�̷� �ο찡 ���� ���̰�.. 
		int totalRow = 0; 
		int totalRowChaged=0; 
		//Vector(a, b);
		//a ���� �����͸� ������ �� �ִ� ������ ��ü�� �����Ѵ�. 
		//����ﰣ�� ������ ��� b���� �����Ѵ�. 
		Vector vector = new Vector(2, 2);  //������ ���� �ٲ�ų� �߰��� �� 
        Vector vector1 = new Vector(2, 2); //�׳� �� ��ü�� ���� 
        
        for(int i=0; i < models.length; i++){ //row���� ŭ �ݺ��ϸ鼭 
        	
        	 if(models[i].modifiy != 1) //1�� �ƴϸ鼭 
             {
                 if(models[i].getModelStatus() == 2 || models[i].getModelStatus() == 5 || models[i].getModelStatus() == 3 || models[i].getModelStatus() == 6)  //�׳� �� ��ü�� ����     
                	 		//insert ,update				update			    �߰� ��ư(��) ���� ���                              		 select
                     vector1.addElement(models[i]); //
                 	System.out.println("vector1" + models[i].getName());
                 if(models[i].getModelStatus() == 2 || models[i].getModelStatus() == 4 || models[i].getModelStatus() == 5)  //������ ���� �ٲ�ų� �߰��� �� 
                	 		//insert  ,update    				delete 		    			update 
                     vector.addElement(models[i]);
              	System.out.println("vector" + models[i].getName());
             }
        	    
        	 totalRow = vector1.size(); //�ȹٲ� ��ü 
        	 totalRowChaged = vector.size(); //�ٲ� ��ü 
        	
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
			//3 : ??? (�߰���) 
			//4 : ����  delete 
			//5 : ����  update 
			
		}
}



