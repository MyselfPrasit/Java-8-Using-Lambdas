package assignment1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateElementRemoval {

	public static void main(String[] args) {
		 List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
         
	        List<String> uniqueStrngs = listOfStrings.stream().distinct().collect(Collectors.toList());
	         
	        System.out.println(uniqueStrngs);

	}

}
