package com.vinoth.algorithms;

import com.doublylinkedlist.vinoth.DoublyLinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class TestDriver.
 */
public class CopyOfTestDriver {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DoublyLinkedList list = new DoublyLinkedList();
		list.addCharAtEnd('H');
	    list.addCharAtEnd('e');
		list.addCharAtEnd('l');
		list.addCharAtEnd('l');
		list.addCharAtEnd('o');
		System.out.println("list:" + list);
		System.out.println("Deleting l");
		list.deleteChar('l');
		System.out.println(list);
		System.out.println("Deleting H");
		list.deleteChar('H');
		System.out.println(list);
		System.out.println("Deleting o");
		list.deleteChar('o');
		System.out.println(list);
		System.out.println("Deleting e");
		list.deleteChar('e');
		System.out.println(list);
		System.out.println("Deleting l");
		list.deleteChar('l');
		System.out.println(list);
		list.addCharAtFront('o');
		list.addCharAtFront('l');
		list.addCharAtFront('l');
		list.addCharAtFront('e');
		list.addCharAtFront('H');
		System.out.println(list);

		System.out.println(list.countNodes());
		
	
		System.out.println("Popping everything");
		while (!list.isEmpty()) {
			System.out.println(list.removeCharFromFront());
		}

		list.addCharAtFront('o');
		list.addCharAtFront('l');
		list.addCharAtFront('l');
		list.addCharAtFront('e');
		list.addCharAtFront('H');
		

		System.out.println("Popping everything from the end");
		while (!list.isEmpty()) {
			System.out.println(list.removeCharAtEnd());
		}
		System.out.println(list.countNodes());

		list.addCharAtEnd('o');
		list.addCharAtEnd('l');
		list.addCharAtEnd('l');
		list.addCharAtEnd('e');
		list.addCharAtEnd('H');
		System.out.println("list:" + list);
		
		list.reverse();
		System.out.println(list);

		 list.reverse();
		System.out.println(list); 

	}

}
