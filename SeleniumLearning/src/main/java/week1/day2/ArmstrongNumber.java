package week1.day2;

public class ArmstrongNumber {

	
		
		/*Armstrong Number in Java: A positive number is called armstrong number 
		 * if it is equal to the sum of cubes of its digits for example 0, 1, 153, 370, 371, 407 etc. ...
		 * 
		 * Goal: To find whether a number is an Armstrong number or not
		 * 
		 * inputs: 153
		 * output: (1*1*1)+(5*5*5)+(3*3*3) = 153
		 * 
		 * Shortcuts:
		 * 1) Print : type: syso, followed by: ctrl + space + enter
		 * 2) To create a While loop, type 'while' followed by: ctrl + space + down arrow + enter
		 * 3) To create an 'if' condition: type 'if', followed by ctrl + space +down arrow + enter
		 *   
		 * What are my learnings from this code?
		 * 1) manually impletemented the logic on sumofdigits and did some changes
		 * 2)helped alot in learn the logic before implementing it
		 * 3)Wrote the logic on note and impleted the code,Happy to get the Output on my own without any reference.
		 * 
		 * 
		 */

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n= 371;
		
	
	int input=0;
		int temp=0;
		int value=0;
		while(n >0)
		{
			input = n % 10;
			temp=input*input*input;
			value =temp+value;
			n=n/10;
				
}

	System.out.println("The Armstrong number of 153 is " + value);	
}}



		

		

		

		



	



