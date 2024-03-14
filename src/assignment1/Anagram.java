package assignment1;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); 
		
	    System.out.println("Enter 1st String");
	    String s1 = myObj.nextLine();
	    
	    System.out.println("Enter 2nd String");
        String s2 = myObj.nextLine();
         
        s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
         
        s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
         
        if (s1.equals(s2)) 
        {
            System.out.println("Two strings are anagrams");
        }
        else
        {
            System.out.println("Two strings are not anagrams");
        }

	}

}
