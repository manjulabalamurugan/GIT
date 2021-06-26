package week8.day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sample  {
	

public static void main(String[] args) {
	String input = "Manjula";
	char[] array = input.toCharArray();
    Arrays.sort(array);

    int max = 0;
    int count = 1;
    char temp = array[0];
    for (char value : array)
    {
        if (value == temp)
        {
            count++;
        }
        else
        {
            temp = value;
            if (count > max)
            {
                max = count;
            }
            count = 1;
        }
    }

    if(count > max)
    {
        max = count;
    }
System.out.println("count : "+max);
        }}
