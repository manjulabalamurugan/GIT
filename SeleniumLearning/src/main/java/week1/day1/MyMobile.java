package week1.day1;

public class MyMobile {
	
	public static void name (String[] args)
	{
		MobilePhone Mymobile = new MobilePhone();
		Mymobile.mobileNames("Samsung");
		boolean mmobile = Mymobile.isMobile();
		System.out.println(mmobile);
		System.out.println(Mymobile.mobileName);
		System.out.println(Mymobile.modelno);
		
	}
	


}
