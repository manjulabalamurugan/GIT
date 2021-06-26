package javaPractice;

import java.util.Arrays;

public class DuplicateInArray {

/*
 * question
 * Find duplicates in an array
 * Input:12233
N = 5
a[] = {2,3,1,2,3}
Output: 2 3 
Explanation: 2 and 3 occur more than once
in the given array.
 */

	public static void main(String[] args) {
	int[] a= {2,3,1,2,3};
	Arrays.sort(a);
	System.out.println(Arrays.toString(a));
for (int i = 0; i < a.length; i++) {
	try {
	if(a[i]==a[i+1])
	{
		System.out.println(a[i+1]);
		
	}}
	catch(ArrayIndexOutOfBoundsException e)
	{
		
	}
	
}
	}

}
