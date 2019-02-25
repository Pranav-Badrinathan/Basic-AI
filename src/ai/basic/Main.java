package ai.basic;

import ai.basic.util.ItemStorage;

public class Main {

	public static void main(String[] args) 
	{	
		System.out.println("Hello, World!");
		
		ItemStorage.initDrawItems();
		ApplicationWindow.createFrame(500, 600);
	}
}
