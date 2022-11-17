package com.aula;

import java.util.ArrayList;

public class ArrayListExemplo {

	public static void main(String[] args) {
		
		ArrayList<String> items = new ArrayList<String>();
		items.add("red");
		items.add(0, "yellow");
		
		/**
		 * Display
		 */
		display(items, "Initial Items");
		
		display(items, "Display list contents with enhanced for statment");
		
		items.add("green");
		items.add("yellow");
		display(items, "List with two new elements");
		
		items.remove("yellow");
		display(items, "Remove first instance of yellow");
		
		items.remove(1);
		display(items, "Remove second list element (green)");
		
		System.out.printf("\"red\" is %sin the list%n", items.contains("red") ? "" : "not ");
		
		System.out.printf("Size: %s%n", items.size());
	}
	
	private static void display(ArrayList<String> items, String descript) {
		System.out.printf("%s: ", descript);
		for (String item : items) {
			System.out.printf(" %s,", item);
		}
		System.out.println("\n");
	}

}
