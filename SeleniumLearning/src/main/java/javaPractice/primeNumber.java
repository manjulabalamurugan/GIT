package javaPractice;
// 2, 3, 5, 7, 11, 13, 17.... are the prime numbers.
//0 and 1 are not prime numbers.
//number which is divisible only by itself
public class primeNumber {
	public static void main(String[] args) {
	int i,m=0,flag=0;      
	 int n=7; 
	
	  m=n/2;     
	  
	  if(n==0||n==1)
	  {  
	   System.out.println(n+" is not prime number");      
	  }
	  
	  else
	  {  
	   for(i=2;i<=m;i++)
	   {      
	    if(n%i==0)
	    {      
	     System.out.println(n+" is not prime number");      
	     flag=1;      
	     break;      
	    }      
	   }      
	   if(flag==0) 
	   { System.out.println(n+" is prime number");
	   }  
	  }//end of else  
	    
}}
