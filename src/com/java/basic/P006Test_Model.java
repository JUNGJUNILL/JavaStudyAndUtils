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

		//isNew가 true 면서 isDelete가 true 인경우   
		// isModifiy가 false or true인 경우 1을 반환 
		// 1을 반환한다.                    ----------------------추가+삭제 1을 반환(insert, delete) 
		//							    ----------------------추가+삭제+수정 1을 반환(insert, delete,update) 
		
		//isNew가 true면서 isDelete가 false 인 경우 
		//isModifiy가 false면 3을 반환 		----------------------추가만 한 경우 3을 반환(insert) 
		//isModifiy가 true면 2를 반환 	    ----------------------추가 + 수정 한 경우 2 반환 (insert , update) 
		
		//isNew가 false면서 isDelete가 true 인 경우 
		//isModifiy가 false면 4를 반환 		---------------------- 삭제만 한 경우 4 반환 (delete)
		//isModifiy가 true면 4를 반환        	    ---------------------- 무언가 삭제 + 수정 한 경우 4를 반환  (delete , update)
		
		//isNew가 false, isDelete가 false면 
		//isModifiy가 false면 6을 반환                ---------------------- 아무것도 안하면 그냥 조회 6을 반환 ( select ) 
		//isModifiy가 true면 5를 반환                  ---------------------- 무언가 수정한 경우  5를 반환 (update)
		
		
		if(true){
			
			if(true)
				System.out.println(2);
			

			System.out.println(1);
		}
		
		
		


	}
	

	

}
