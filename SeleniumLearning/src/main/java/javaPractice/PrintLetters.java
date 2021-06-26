package javaPractice;

public class PrintLetters {

	
	public static void main(String[] args) {
		String input = "vignesh waran.k";
		
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if(charArray[i]=='.')
			{
				i++;
				System.out.println(charArray[i]);
			}
			
		}
		
	}

}
