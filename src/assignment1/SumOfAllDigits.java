package assignment1;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumOfAllDigits {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in); 
		
	    System.out.println("Enter the Number");
	    int i = myObj.nextInt();
		
        
        Integer sumOfDigits = Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
         
        System.out.println(sumOfDigits);

	}

}
