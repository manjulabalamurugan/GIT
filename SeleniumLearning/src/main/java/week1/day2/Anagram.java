package week1.day2;
import java.util.Arrays;
import org.apache.tools.ant.types.CommandlineJava.SysProperties;

public class Anagram {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo Code
		  
		 *Declare a String 
			String text1 = "stops";
		 *Declare another String
			String text2 = "potss"; 
		 * a) Check length of the strings are same then (Use A Condition)
		 * b) Convert both Strings in to characters
		 * c) Sort Both the arrays
		 * d) Check both the arrays has same value
		 * 
		 */
		
		String text1 = "stops";
		String text2 = "potss";
		 char[] word1 = text1.toCharArray();
	        Arrays.sort(word1);
	        String sorted = new String(word1);
	        System.out.println("Sorted the words : "+ sorted); 
	        //System.out.println(Arrays.toString(word1));
	        
	        char[] word2 = text2.toCharArray();
	        Arrays.sort(word2);
	        String sorted2 = new String(word2);
	        System.out.println("Sorted the words : "+sorted2);
		
		int countofloops=0;
		if(text1.length()!=text2.length())
		{
			
			System.out.println("length are not same");
		}	
			else
			{
			System.out.println("length are same");		
		for (int i = 0; i <= word1.length-1; i++) 
		{
			if( word1[i] == word2[i] )
			{
				countofloops=countofloops+1;
			//
			continue;
			}
			else
			{
				System.out.println("Not Anagram");
				break;
			}	
		}
		if(countofloops== word1.length)
			
			System.out.println("Both words are same and its anagram" );
		
	}}}

