package testcase1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count=0;
		//array = a,b,a,b,c,d
				
		int[] a = {'a','b','a','b','c','d'};
		//a.length
		String string = a.toString();
		//System.out.println(string.));
		char[] charArray = string.toCharArray();
		
		Arrays.parallelSort(a);
		
		Map<Integer,Integer> counter = new HashMap<Integer,Integer>();
		
		for(Integer ch : a )
		{
			if(counter.containsKey(ch))
			{
				counter.put(ch, counter.get(ch)+1);
			}
			else
			{
				counter.put(ch, 1);
			}
			
		}
		
		System.out.println(counter);
		for(int i =0;i<=a.length;i++)
		{
			count = count+1;
		}
		System.out.println(count);
		
		
		
		
	}
	 public boolean isValidEmailAddress(String email) {
         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
         java.util.regex.Matcher m = p.matcher(email);
         return m.matches();
  }
}
