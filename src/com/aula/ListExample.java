package com.aula;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListExample {

	public static void main(String[] args) {
		String[] colors = {"MAGENTA", "RED", "WHITE", "BLUE", "CYAN"};
		
		/**
		 * List<ClassType> varible = new Object<ClassType>();
		 * 
		 * É possível substituir uma classe pai com uma classe filho, vez que ArrayList extende a classe List (Processo de substituição)
		 */
		List<String> colorsList = new ArrayList<String>();
		
		for (String color : colorsList) {
			colorsList.add(color);
		}
		
		String[] colorsToRemove = {"MAGENTA", "RED", "WHITE"};
		List<String> colorsToRemoveList = new ArrayList<String>();
		
		for (String color: colorsToRemove) {
			colorsToRemoveList.add(color);
		}
		
		System.out.println("ArrayList: ");
		for (int i = 0; i < colorsList.size(); i++) {
			System.out.printf("%s ", colorsList.get(i));
		}
		
		removeColors(colorsList, colorsToRemoveList);
		
		System.out.printf("%n%nArrayList after cakkubg reniveCikirs %n");
		System.out.println("ArrayList: ");
		for (String color: colorsList) {
			System.out.printf("%s", color);
		}
	}
	
	private static void removeColors(Collection<String> collection, Collection<String> collectionToRemove) {
		Iterator<String> iterator = collection.iterator();
		
		while (iterator.hasNext()) {
			if (collectionToRemove.contains(iterator.next())) {
				iterator.remove();
			}
		}
	}

}
