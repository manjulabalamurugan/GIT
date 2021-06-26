package week5.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MoveArrayElements {

	//Array - list of numbers
	//{4,3,0,0,3,0} - move all 0 to right
	//o/p " {4,3,3,0,0,0}

	public static void main(String[] args) {
		int[] a = {4,3,0,0,3,0};
		//List<Integer> arrayList = Arrays.asList(4,3,0,0,3,0);
		List<Integer> list1=new ArrayList<Integer>();
		List<Integer> list2=new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if(a[i]!=0)
			{
				
				list1.add(a[i]);
			}
			else
			{
				list2.add(a[i]);
			}
			
		}
			
				 List merged = new ArrayList(list1);
			        merged.addAll(list2);
			        System.out.println(merged);
		
	//Another Method :		
	//Collections.sort(list1,Collections.reverseOrder());
	//System.out.println(list1);

	}

}
