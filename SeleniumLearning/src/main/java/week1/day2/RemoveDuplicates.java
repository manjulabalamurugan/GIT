package week1.day2;

public class RemoveDuplicates {

	/*
	 * Pseudo code 
	 
	 * a) Use the declared String text as input
		String text = "We learn java basics as part of java sessions in java week1";		
	 * b) Initialize an integer variable as count	  
	 * c) Split the String into array and iterate over it 
	 * d) Initialize another loop to check whether the word is there in the array
	 * e) if it is available then increase and count by 1. 
	 * f) if the count > 1 then replace the word as "" 
	 
	 * g) Displaying the String without duplicate words	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     String text="We learn java basics as part of java sessions in java week1";
     
 int count=0;
	String[] words = text.split(" ");
	System.out.println(words.length);
     
	for(int i=0;i<words.length;i++)    //Outer loop for Comparison and to check if sentence is empty or not    
    {
      if(words[i]!=null)
      {
      
      for(int j=i+1;j<words.length;j++)          //Inner loop to compare two words in a sentence to check for duplicacy
      {
        
      if(words[i].equals(words[j]))          //Checking if both the compared strings are equal words[i].equals(words[j]
        {
          words[j]=""; 
          count=count+1;
          			                         //Deletes the duplicate words if the compared strings are equal
        }
      }
      }
    }
    for(int k=0;k<words.length;k++)    //Displaying the String without the duplicate words  
    {
      if(words[k]!=null)
      {
        System.out.print(words[k] + " ");
      }
    }
     
 
     
     
     
	  
     
     
     
	}

}
