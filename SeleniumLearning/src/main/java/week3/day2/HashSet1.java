package week3.day2;

import java.util.HashSet;
import java.util.Set;

public class HashSet1 {
//remove dup
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String companyname1 = "TESTLEAF";
		char[] charArray = companyname1.toCharArray();
		
		Set<Character> unique = new HashSet<Character>() ;
		for(int i=0;i<charArray.length;i++)
		{
			if(unique.add(charArray[i]))
					{
				System.out.println(charArray[i]);
					}
		}
		
		
		
	}

}
