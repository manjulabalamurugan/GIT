package javaPractice;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterOccurence {

	
	public static void main(String[] args) {
		String str = "Welcome to Wipro";
		Map<Character,Integer> charMapCount = new HashMap<Character,Integer>();
		
		for (Character c : str.toCharArray()) {
			if(charMapCount.containsKey(c))
			{
				charMapCount.put(c, charMapCount.get(c)+1);
			}
			else
			{
				charMapCount.put(c, 1);
			}
			
			
			
		}
		
System.out.println(charMapCount);


	}

}
