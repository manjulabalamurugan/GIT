package week1.day2;

public class Demo {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "wordTochaNge";
		
		String upper = input.toUpperCase();
		
		char[] charArray = input.toCharArray();
		
		char[] charArray2 = upper.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			
			if(i % 2 == 0)
			{
				System.out.print(charArray2[i]);
			}
			else
			{
				System.out.print(charArray[i]);
			}
		}
		
	}

}
