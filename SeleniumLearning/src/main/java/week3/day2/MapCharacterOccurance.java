package week3.day2;

import java.util.HashMap;

import java.util.Map;

/*
PseudoCode:
1. Create a String with your name as value
2. Convert the string into a char array		
3. Create an empty Map<Character,Integer>
4. Iterate over the array
5. Check whether the Map contains the Character
6. If it contains then increment the key (+1)
7. Add the character in the map & set the value as 1
8. Print the Map
*/
public class MapCharacterOccurance {
public static void main(String[] args) {
		String value = "welcome to Selenium automation";
		char[] charArray = value.replace(" " , "").toCharArray();
		Map<Character, Integer> eachValue = new HashMap<Character,Integer>();
		
		for (int i = 0; i < charArray.length; i++) {
			if(eachValue.containsKey(charArray[i]))
			{
				eachValue.put(charArray[i], eachValue.get(charArray[i])+1);
			}
			else
			{
				eachValue.put(charArray[i], 1);
			}
		}
System.out.println(eachValue);
	}

}
