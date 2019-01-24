package com.tracker.demand.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListCompare {
	public static void main(String[] args) {
		String Skill =  "Java,Spring, Hibernate,Kafka,Hadooop";
		List<String> aList = Arrays.asList(Skill.split(","));
		String Skill2 =  "1, 12,10, 1,12, Kafka";
		List<String> bList = Arrays.asList(Skill2.split(","));
		
//        List < String > aList = Arrays.asList(new String[] {
//            "Java",
//            "Spring",
//           " Hibernate",
//            "Kafka",
//            "Hadooop"
//        });
//        List < String > bList = Arrays.asList(new String[] {
//            "10",
//            "Java",
//            "8",
//            "9"
//        });
		
		
		String pattern = aList.stream()
		          .map(Pattern::quote)
		          .collect(Collectors.joining("|", ".*(", ").*"));

		    Pattern re = Pattern.compile(pattern);
		    System.out.println(  "If any number from aList is present in List 2 :" + bList.stream()
			        .anyMatch(t -> re.matcher(t).matches()));
        // If any number from List is present in List 2
        System.out.println(
            "If any number from aList is present in List 2 :" +
            aList.stream().anyMatch(num -> bList.contains(num)));
        // If any number from List is present in List 2
        System.out.println(
            "If any number from aList is not present in List 2 :" +
            aList.stream().noneMatch(num -> bList.contains(num)));
        // If any number from List is present in List 2
        System.out.println(
            "If all numbers from aList are present in List 2 :" +
            aList.stream().allMatch(num -> bList.contains(num)));
    }
}
