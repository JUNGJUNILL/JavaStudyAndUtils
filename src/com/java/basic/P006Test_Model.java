package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class P006Test_Model {
	
  	private boolean isNew;
    private boolean isModify;
    private boolean isDelete;
    
    public int getModelStatus()
    {
        if(isNew)
        {
            if(isDelete) return !isModify ? 1 : 1;
            
            return !isModify ? 3 : 2;
        }
        if(isDelete) return !isModify ? 4 : 4;
        
        return !isModify ? 6 : 5;
    }

	public static void main(String[] args) throws GeneralException {

		//isNew�� true �鼭 isDelete�� true �ΰ��   
		// isModifiy�� false or true�� ��� 1�� ��ȯ 
		// 1�� ��ȯ�Ѵ�.                    ----------------------�߰�+���� 1�� ��ȯ(insert, delete) 
		//							    ----------------------�߰�+����+���� 1�� ��ȯ(insert, delete,update) 
		
		//isNew�� true�鼭 isDelete�� false �� ��� 
		//isModifiy�� false�� 3�� ��ȯ 		----------------------�߰��� �� ��� 3�� ��ȯ(insert) 
		//isModifiy�� true�� 2�� ��ȯ 	    ----------------------�߰� + ���� �� ��� 2 ��ȯ (insert , update) 
		
		//isNew�� false�鼭 isDelete�� true �� ��� 
		//isModifiy�� false�� 4�� ��ȯ 		---------------------- ������ �� ��� 4 ��ȯ (delete)
		//isModifiy�� true�� 4�� ��ȯ        	    ---------------------- ���� ���� + ���� �� ��� 4�� ��ȯ  (delete , update)
		
		//isNew�� false, isDelete�� false�� 
		//isModifiy�� false�� 6�� ��ȯ                ---------------------- �ƹ��͵� ���ϸ� �׳� ��ȸ 6�� ��ȯ ( select ) 
		//isModifiy�� true�� 5�� ��ȯ                  ---------------------- ���� ������ ���  5�� ��ȯ (update)
		
		
		if(true){
			
			if(true)
				System.out.println(2);
			

			System.out.println(1);
		}
		
		
		


	}
	

	

}
