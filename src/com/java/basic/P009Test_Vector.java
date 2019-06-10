package com.java.basic;

import java.awt.Point;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

public class P009Test_Vector {

	public static void main(String[] args) throws GeneralException {
		

		  String inp= new String();
		  Scanner scan = new Scanner(System.in);
		  System.out.println("Enter Word ");
		  inp = scan.nextLine();
		  int output = 1;
		  int [] board = new int[40];
		  int points = 0; 
		  int totalpoints = 0;
		  int input;
		  //start of for loop
		  for(int i = 0; i < 5; i++)
		  {
		     input = scan.nextInt();
		     for (int j = 0; j < inp.length(); j++)
		     {
		        //values of letters
		        if(inp.charAt(i) == 'a' || inp.charAt(i) == 'e')
		        {
		           points = 1;
		        }
		        else if(inp.charAt(i) == 'd' || inp.charAt(i) == 'r') 
		        {
		           points = 2;
		        }
		        else if(inp.charAt(i) == 'b' || inp.charAt(i) == 'm')
		        {
		           points = 3;
		        }
		        else if(inp.charAt(i) == 'v' || inp.charAt(i) == 'y')
		        {
		           points = 4;
		        }
		        else if(inp.charAt(i) == 'j' || inp.charAt(i) == 'x')
		        {
		           points = 8;
		        }
		        else
		        {
		           points = points; 
		        }
		        //checking if double letter or triple letter and executing program
		        if ( input % 3 == 0 && input % 6 != 0)
		        {
		           points = points * 2;
		        }
		        else
		        {
		           points = points;

		        }   
		        if (input % 5 == 0 && input != 15)
		        {
		           points = points * 3;
		        }
		        else 
		        {
		           points = points;
		        }
		        totalpoints = totalpoints + points;
		        input = input + 1;
		     }//end of for loop
		     input = input - 4;
		     //checking if double word or triple word and executing program
		     for (int k = 0; k < inp.length(); k++)
		     {   
		        if (input % 7 == 0 && input != 21 && input != 25)
		        {
		           totalpoints = totalpoints * 2;
		        }
		        else
		        {
		           totalpoints = totalpoints;
		        }

		        if (input % 8 == 0 && input != 40)
		        {
		           totalpoints = totalpoints * 3;
		        }
		        else
		        {
		           totalpoints = totalpoints;
		        }
		        input = input + 1;
		     }
		  }
		  System.out.println(totalpoints);
		}

	
}


