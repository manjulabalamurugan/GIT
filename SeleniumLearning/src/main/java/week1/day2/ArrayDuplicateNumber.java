package week1.day2;
import java.util.Arrays;
public class ArrayDuplicateNumber {

	public static void main(String[] args) {
		
     int[] number = {2,5,3,7,2,7,2,1};
      Arrays.sort(number);
     //System.out.println(Arrays.toString(number));
     for(int i=0; i<number.length; i++)
     {
    	 if(number[i]==number[i+1])
    		 { System.out.println("The first smallest duplicate number is " + number[i]);
    		 break;
     
    		 }
     
     
	}
	}

}
