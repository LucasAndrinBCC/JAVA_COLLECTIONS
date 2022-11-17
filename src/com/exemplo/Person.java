package com.exemplo;

import java.time.LocalDate;

public class Person {
	
	private String name;
	private String email;
	private LocalDate birthDate;
	
	public Person(String name, String email, LocalDate birthDate) {
		super();
		setName(name);
		setEmail(email);
		setBirthDate(birthDate);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() >= 3) {
			this.name = name;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() > 0) {
			this.email = email;
		}
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public int getAge() {
		LocalDate now = LocalDate.now();
		
		int age = now.getYear() - birthDate.getYear();
		
		if (now.getMonthValue() < birthDate.getMonthValue() || now.getMonthValue() == birthDate.getMonthValue() && now.getDayOfYear() < birthDate.getDayOfYear()) {
			age--;
		}
		
		return age;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", getAge()=");
		builder.append(getAge());
		builder.append("]");
		return builder.toString();
	}
	
}
