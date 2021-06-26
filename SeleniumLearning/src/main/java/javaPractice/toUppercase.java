package javaPractice;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class toUppercase {

	
	public static void main(String[] args) {
	/*	
		Scanner result = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String data = result.nextLine();
		Scanner input_data = new Scanner(data);
		String uppercase = " ";
		while(input_data.hasNext())
		{
			String word = input_data.next();
			uppercase += Character.toUpperCase(word.charAt(0))+word.substring(1)+" ";
		}
		System.out.println(uppercase);
		*/
		java.util.List<Integer> arrayval = new ArrayList<Integer>();
		String str = "geeks for geeks";
		char[] y = str.toCharArray();
		y[0]=(char)(y[0]-32);
		
		int size = y.length;
		int i=1;
		while(i!=size)
		{
			if(y[i]==' ')
			{
				y[i+1] = (char)(y[i+1]-32);
				
			}
			i++;
		}
		System.out.println(y);
	}

}
