package javaPractice;

public class AddCharacterToStringAnyPosition {
	 
    public static void main(String[] args) {
        String blogName = "123456789";
        String two ="|";
        String cblogName = addCharToStringUsingSubString(blogName,two,4);
       
        System.out.println(cblogName);
    }
 
    public static String addCharToStringUsingSubString(String str, String c, int pos) {
        return str.substring(0, pos)+ c +str.substring(pos);
    }
}

