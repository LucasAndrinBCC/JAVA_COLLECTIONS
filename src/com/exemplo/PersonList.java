package com.exemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PersonList {
	
	private List<Person> list = new ArrayList<Person>();
	
	public List<Person> getList() {
		return list;
	}

	public void setList(List<Person> list) {
		this.list = list;
	}
	
	/*
	 * Search Funcitons	
	 */
	public Person getPersonByName(String name) {
		for (Person person : list) {
			if (name.equals(person.getName())) {
				return person;
			}
		}
		
		return null;
	}
	
	public Set<String> getPeopleDomains() {
		Set<String> set = new HashSet<String>();
		
		for (Person person : list) {
			String personEmail = person.getEmail();
			int start = personEmail.indexOf("@") + 1;
			int end = personEmail.indexOf(".com");
			
			set.add(personEmail.substring(start, end));
		}
		
		return set;
	}
	
	public List<Person> searchPersonByName(String name) {
		List<Person> peopleSearched = new ArrayList<Person>();
		for (Person person : list) {
			if (person.getName().toLowerCase().contains(name.toLowerCase())) {
				peopleSearched.add(person);
			}
		}
		
		return peopleSearched;
	}
	
	public List<Person> searchPeopleByBirthDateOfYearMonth(LocalDate date) {
		List<Person> peopleSearched = new ArrayList<Person>();
		for (Person person : list) {
			LocalDate birthDate = person.getBirthDate();
			if (birthDate.getMonthValue() == date.getMonthValue() && birthDate.getYear() == birthDate.getYear()) {
				peopleSearched.add(person);
			}
		}
		
		return peopleSearched;
	}
	
	public List<Person> searchPersonByAge(int age, String operator) {
		List<Person> people = new ArrayList<Person>();
		
		for (Person person : list) {
			if (relativeAgeComparition(person.getAge(), age, operator)) {
				people.add(person);
			}
		}
		
		return people;
	}
	
	public Set<Person> searchPersonByAge(int age) {
		Set<Person> set = new HashSet<Person>();
		
		for (Person person : list) {
			if (person.getAge() == age) {
				set.add(person);
			}
		}
		
		return set;
	}
	
	/*
	 * Refactor Functions
	 */
	public boolean add(Person person) {
		if (nameIsUnique(person.getName())) {
			list.add(person);
		}
		
		return false;
	}
	
	public boolean removeByName(String name) {
		for (Person person : list) {
			if (name.equals(person.getName())) {
				list.remove(person);
				return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Auxiliar Funcitons	
	 */
	private boolean relativeAgeComparition(int personAge, int age, String operator) {
		switch (operator) {
		case ">":
			return personAge > age;
		case ">=":
			return personAge >= age;
		case "<":
			return personAge < age;
		case "<=":
			return personAge <= age;
		case "!=":
			return personAge != age;
		default:
			return personAge == age;
		}
	}
	
	/*
	 * Validation Rules
	 */
	private boolean nameIsUnique(String name) {
		for (Person person : list) {
			if (name.equals(person.getName())) {
				return false;
			}
		}
		
		return true;
	}
}
