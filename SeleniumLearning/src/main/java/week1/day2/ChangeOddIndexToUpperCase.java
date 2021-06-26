package week1.day2;

public class ChangeOddIndexToUpperCase {
	/*
	 Pseudo Code
	 
	 * Declare String Input as Follow
	  
	 * String test = "changeme";
	 
	 * a) Convert the String to character array
	 
	 * b) Traverse through each character (using loop)
	 
	 * c)find the odd index within the loop (use mod operator)
	 
	 * d)within the loop, change the character to uppercase, if the index is odd else don't change
	  
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	
		String test = "changeme";
		char[] array= test.toCharArray();
		
		//String result= test.substring(1,2).toUpperCase();
		//System.out.println (result);
			for(int i=0;i<array.length;i++)
			{
				if(i%2!=0)
				{ array[i]=Character.toUpperCase(array[i]);
			
				}
				
			}
			String string=new String(array);
			System.out.println(string);
	}}
