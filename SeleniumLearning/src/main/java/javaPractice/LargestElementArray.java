package javaPractice;

import java.util.Arrays;

public class LargestElementArray {

	/*
	 * Input:
n = 5
A[] = {1, 8, 7, 56, 90}
Output:
90
Explanation:
The largest element of given array is 90.
	 */
	
	public static void main(String[] args) {
		int[] A= {1, 8, 7, 56, 90};
		Arrays.sort(A);
		int value=0;
		int value1=A[0];
		for (int i = 0; i < A.length; i++) {
			if(A[i]>value )
			{
				value=A[i];
				
			}
			
		}
		System.out.println("The largest element of given array is "+ value);
		
		
		for (int j = 0; j < A.length; j++) {
			if(A[j] > value1)
			{
				
				value=A[j];
				
			}
			
		}
		System.out.println("The smallest element of given array is "+ value1);
	}

}
