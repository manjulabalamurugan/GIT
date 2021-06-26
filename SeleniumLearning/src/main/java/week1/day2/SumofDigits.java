package week1.day2;

public class SumofDigits {

		/*
		 * Goal: Find the sum of digits of a given number
		 * 
		 * input: 123
		 * output: 1+2+3 = 6
		 * 
		 * Shortcuts:
		 * 1) Print : type: syso, followed by: ctrl + space + enter
		 * 2) To create a 'while' loop: type 'while', followed by ctrl + space + enter
		 *   
		 * What are my learnings from this code?
		 * 1)learned how to use temp variable
		 * 2)got some idea on using the modulus
		 * 3) practised manually on the calculations
		 * 
		 */
		public static void main(String[] args) {


				int input=123;
	
				int sum=0;
				int temp=0;
				while(input >0)
				{
					temp = input % 10;
					sum= sum + temp;
					input = input / 10;				
		}

			System.out.println(sum);	
}}