package com.exemplo;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		String[] names = {
				"Moar", "Ghorgi", "Teidhu",
				"Gloripiobau", "Hoyeruilos", "Seguyis", 
				"Huili", "Seguyis", "Asnya", "Niesn"
		};
		
		String[] domains = {"gmail", "yahoo", "outlook", "hotmail"};
		
		Random random = new Random();
		
		LocalDate birthDate = LocalDate.parse("2005-05-03");
		
		PersonList peopleList = new PersonList();
		
		for (String name : names) {
			StringBuilder email = new StringBuilder();
			email.append(name.toLowerCase());
			email.append("@");
			email.append(domains[random.nextInt(0, domains.length)]);
			email.append(".com");
			
			Person person = new Person(name, email.toString(), birthDate);
			
			peopleList.add(person);
			
			birthDate = birthDate.minusWeeks(2).minusMonths(6);
		}
		
		List<Person> people = peopleList.getList();
		
		System.out.println("Listing People");		
		for (Person item : people) {
			System.out.println(item.toString());
		}
		
		System.out.println("Listing Domais");
		for (String domain : peopleList.getPeopleDomains()) {
			System.out.println(domain);
		}
		
		System.out.println("Deleting Moar...");
		peopleList.removeByName("Moar");
		System.out.println("Listing People");		
		for (Person item : people) {
			System.out.println(item.toString());
		}
		
		System.out.println("Deleting Ghorgi... to Ghorgiiiiii");
		Person person = peopleList.getPersonByName("Ghorgi");
		person.setName("Ghorgiiiiii");
		System.out.println(person);
		
		System.out.println("Searching People by name ilike \"or\"");
		List<Person> searchedPeople = peopleList.searchPersonByName("or");
		System.out.println(searchedPeople);
		
		System.out.println("Searching People by age > 18");
		searchedPeople = peopleList.searchPersonByAge(18, ">");
		System.out.println(searchedPeople);
		
		System.out.println("Searching People by birth date");
		LocalDate now = LocalDate.parse("2003-03-08");
		searchedPeople = peopleList.searchPeopleByBirthDateOfYearMonth(now);
		System.out.println(searchedPeople);
	}

}
