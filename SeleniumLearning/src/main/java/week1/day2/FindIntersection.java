package week1.day2;

import java.util.Arrays;

public class FindIntersection {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Pseudo Code
		
		 * a) Declare An array for {3,2,11,4,6,7};	 
		 * 
		 * b) Declare another array for {1,2,8,4,9,7};
		 * c) Declare for loop iterator from 0 to array length
		 * d) Declare a nested for another array from 0 to array length
		 * e) Compare Both the arrays using a condition statement
		 
		 *  f) Print the first array (shoud match item in both arrays)
		 */
		
		int[] array= {3,2,11,4,6,7};
			Arrays.sort(array);
		 	System.out.println(Arrays.toString(array));
		int[] array1= {1,2,8,4,9,7};
			Arrays.sort(array1);
			System.out.println(Arrays.toString(array1));
		for(int i=0;i<array.length;i++)
		{
			for( int j=0;j<array.length;j++ )
			{ if(array[i]==array1[j])
				{
				System.out.println( array[i]+ " ");
				
				}
			
		}	}
		System.out.println( "2 4 7 are the common intersection on these 2 Arrays"); 
		
	}}


