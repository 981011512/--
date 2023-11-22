package com.cf.forward.dh.common;

import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class CaseMenu {
	
	public static class Item {
		private Object object;
		private String itemName;
		private String methodName;
		
		public Item(Object object, String itemName, String methodName) {
			super();
			this.object = object;
			this.itemName = itemName;
			this.methodName = methodName;
		}

		public Object getObject() {
			return object;
		}

		public String getItemName() {
			return itemName;
		}

		public String getMethodName() {
			return methodName;
		}
	}
	
	private Vector<Item> items;

	public CaseMenu() {
		super();
		items = new Vector<Item>();
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	private void showItem() {
		final String format = "%2d\t%-20s\n";
		int index = 0; 
		System.out.printf(format, index++, "exit App");
		for (Item item : items) {
			System.out.printf(format, index++, item.getItemName());
		}
		System.out.println("Please input a item index to invoke the method:");
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(true) {			
			showItem();			
			try {		
				int input = Integer.parseInt(scanner.nextLine());

				if (input <= 0 ) {
					System.err.println("input <= 0 || scanner.nextLine() == null");
//					scanner.close();
//					System.exit(0);
					break;
				}
					
				if (input < 0 || input > items.size()) {
					System.err.println("Input Error Item Index.");
					continue;
				}
				
				Item item = items.get(input - 1);
				Class<?> itemClass = item.getObject().getClass();
				Method method = itemClass.getMethod(item.getMethodName());
				method.invoke(item.getObject());
			} catch (NoSuchElementException e) {
//				scanner.close();
//				System.exit(0);
				break;
			} catch (NumberFormatException e) {
				System.err.println("Input Error NumberFormat.");
				continue;
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		scanner.close();
	}
}
