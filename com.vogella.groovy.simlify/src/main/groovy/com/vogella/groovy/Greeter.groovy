package com.vogella.groovy;

import java.util.List;
import java.util.ArrayList;

public class Greeter {

	private List<String> greetings = new ArrayList<>();
	
	private Map<String, String> greetingMap = new HashMap<>();
	
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public List<String> getGreetings() {
		return greetings;
	}

	public String greet(String name) {
		String greeting = "Hello " + name + ", I am " + owner;
		greetings.add(greeting);
		greetingMap.put(name, greeting);
		return greeting;
	}

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		greeter.setOwner("Simon");
		System.out.println(greeter.greet("Gradle"));
	}
}

