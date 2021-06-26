package week1.day2;

public class Palindrome {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo Code
		
		 * a) Declare A String value as"madam"
		 
		 * b) Declare another String rev value as ""
		 * c) Iterate over the String in reverse order
		 * d) Add the char into rev
		 * e) Compare the original String with the reversed String, if it is same then print palinDrome 
		 
		 * Hint: Use .equals or .equalsIgnoreCase when you compare a String 
		 */
		
		
		String name="madam";
		String reverse = "";
		char[] everchar=name.toCharArray();
		for(int i=everchar.length-1;i>=0;i--)
		{   
			reverse=reverse+everchar[i];
		    System.out.print(everchar[i]);
		    
			if(name.equalsIgnoreCase(reverse))
			{
			System.out.println(" is a palindrome");
			}
			
	}

	}}
