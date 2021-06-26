package week1.day2;

public class SumOfDigitsFromString {
	/*
	 * Method 1
	 * Pseudo Code
	 
	 * Declare a String text with the following value
		String text = "Tes12Le79af65";
	   Declare a int variable sum
		int sum = 0;
	 * a) using replaceAll(), replace all the non-digits into ""
	 * b) Now, convert the String into array
	 * c) Iterate over the array and get each character
	 * d) Using Character.getNumericValue(), Change the char into int
	 * e) Add the values to sum & print
	 * 
	 */
	
	public static void main(String[] args) {
	
		String text = "Tes12Le79af65";
		int sum = 0;
		String text1 =text.replaceAll("\\D", "");
		System.out.println("Removed all the alphabets from Tes12Le79af65: " + text1);
		char[] everychar=text1.toCharArray();
		
		for(int i=0;i<=everychar.length-1;i++)
		{
			int result=Character.getNumericValue(everychar[i]);
			sum=sum+result;
			
		}
		System.out.println("The sum of the digits of 127965 is " + sum);
	}

}
