package javaPractice;

import java.util.Scanner;

public class PrintNextLetterOfEachCharacter {

	

	public static void main(String[] args) {
		//String numarray = "abcdefghijklmnopqrstuvwxyz";
		//char[] charArray = numarray.toCharArray();
		//Scanner sc = new Scanner(System.in); 
		
		//System.out.print("Enter a String ");  
		//String input = sc.next();
		String a = "hello";
		for (int i = 0; i < a.length(); i++) {
			
				char ch = a.charAt(i);
				ch++;
				System.out.println(ch);
				
			
			
		}
		

	}

}
