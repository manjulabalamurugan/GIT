package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Declare a String as PayPal India
		String input = "PayPal";
//		Convert it into a character array
        char[] charArray = input.toCharArray();
//		Declare a Set as charSet for Character
        Set<Character> charSet = new HashSet<Character>();
       
//		Declare a Set as dupCharSet for duplicate Character
        Set<Character> dupCharSet = new HashSet<Character>();
//		Iterate character array and add it into charSet
       for (int i = 0; i < charArray.length; i++) 
       {
    	   Character c = input.charAt(i);
    	   	if(!charSet.contains(c))
    	   		{
    	   			charSet.add(c);
    	   		}
    	   	else
    	   		{
    	   		dupCharSet.add(c);
    	   		}
		
       }
       System.out.println("Set without duplicate characters of Paypal : " + charSet);   
       System.out.println("Set which has duplicate charcters of Paypal :" + dupCharSet);
       		if(charSet.containsAll(dupCharSet))
       			{
       				charSet.removeAll(dupCharSet);
       			}
       System.out.println("Set after removing the common words from both set : " + charSet);  
       
	}}