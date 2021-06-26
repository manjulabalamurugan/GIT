package javaPractice;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWord {

	public DuplicateWord() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String str = "Welcome to Welcome the fan of fan";
		Set<String> set = new HashSet<String>();
		String[] split = str.split(" ");
		
		for (int i = 0; i < split.length; i++) {
			if(!set.add(split[i]))
			{
				System.out.println(" The duplicate words in the sentence are " + split[i]);
			}
		}

	}

}
