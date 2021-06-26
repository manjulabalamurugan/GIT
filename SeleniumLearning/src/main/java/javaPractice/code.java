package javaPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class code {

	

	public static void main(String[] args) {
		//String words[]=str.split("//");  
		String words1 = "My Name is Manjula";
		String[] words=words1.split(" ");  
			    String reverseWord="";  
			    for(String w:words)
			    {  
		        StringBuilder sb=new StringBuilder(w);  
			     StringBuilder reverse = sb.reverse();  
			        //reverseWord+=sb+" ";  
			     System.out.println(reverse);  
			    }  
		    System.out.println(reverseWord);  
			}  


	

}
