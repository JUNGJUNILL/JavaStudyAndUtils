package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Javamemo {

	public static void main(String[] args) {
		Sam s = new Sam(5); 
		Card c = new Card(); 
		System.out.println(c.string);
		System.out.println(c.num);
	}

	

}

class Sam extends test{
	
		Sam(){
			super(5); //상위 클래스의 생성자를 실행해줌 
			System.out.println("Sam");
		}
		Sam(int a, int b){ System.out.println("디폴트 생성자 아님");}
		
		Sam(int a){
			this(); 
		}
		//생성자 함수 안에서만 사용할 수 있다.
		//생성자 함수의 가장 첫 문장으로만 사용할 수 있다. 
		//즉, 다른 함수에서는 생성자 함수를 강제로 호출할 수 없다. 
		
}

abstract class test{
	test(){
		System.out.println("abstract");
	}
	
	test(int a){
		System.out.println("test");
	}
}



class Card{
	
		String string; 
		int num; 
	
		Card(String s, int num){
			this.string = s; 
			this.num = num; 
		}
		
		Card(){
			this("fuck",1); 
		}
	
}