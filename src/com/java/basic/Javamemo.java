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
			super(5); //���� Ŭ������ �����ڸ� �������� 
			System.out.println("Sam");
		}
		Sam(int a, int b){ System.out.println("����Ʈ ������ �ƴ�");}
		
		Sam(int a){
			this(); 
		}
		//������ �Լ� �ȿ����� ����� �� �ִ�.
		//������ �Լ��� ���� ù �������θ� ����� �� �ִ�. 
		//��, �ٸ� �Լ������� ������ �Լ��� ������ ȣ���� �� ����. 
		
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