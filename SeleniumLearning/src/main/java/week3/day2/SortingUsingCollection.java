package week3.day2;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class SortingUsingCollection {

	
	//String[] input = {"HCL","Wipro","Aspire Systems","CTS"}
		
	//		Required Output: Wipro, HCL , CTS, Aspire Systems
	

	public static void main(String[] args) {
		
		
		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		
		
//		get the length of the array		
		System.out.println("The length of the String is  " + input.length);
		
//		sort the array	
		Arrays.sort(input);
//		Iterate it in the reverse order		
		for (int i = input.length-1; i >=0 ; i--) {
			System.out.println(input[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
