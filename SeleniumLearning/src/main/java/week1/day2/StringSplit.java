package week1.day2;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String name = "Amazon Development Center";
   String[] words= name.split(" ");
  
   
 
  for(int i=words.length-1 ;i>=0;i--)
	   
 { //name.reverse()
	   System.out.print(words[i]+" ");
	  
	   //reversed = charArray[i]+reversed;
  }
	}

}
