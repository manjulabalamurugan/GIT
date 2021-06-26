package week1.day1;
public class Computer1 {
	public static void main(String[] args) {
			
				System.out.println("           Computer Details \n      ");
		
		// calling the method from Computer.java	
		 Computer myComp = new Computer();
		 myComp.computerDetails(" Lenovo");
		 boolean computer = myComp.isComputer();
		 		System.out.println(computer);
		 String brand1 = myComp.brand();
				System.out.println(brand1);
		
		//accessing the variable from another class (MobilePhone.java)
		
		MobilePhone m1 = new MobilePhone();
		short modelno  = m1.modelno;
				System.out.println(modelno);  }}
