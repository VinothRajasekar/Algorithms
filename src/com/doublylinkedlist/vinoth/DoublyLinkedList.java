package com.doublylinkedlist.vinoth;

//TODO: Auto-generated Javadoc
/**
 * The Class DoublyLinkedList.
 * 
 * @author Vinoth Rajasekar
 */
public class DoublyLinkedList {

	public DoubleNode head = new DoubleNode();
	private DoubleNode tail = new DoubleNode();

	boolean dchar = false;
	private int count = 0;

	private DoubleNode first;
	private DoubleNode last;
	private DoubleNode temp;
	private DoubleNode temp1;

	/**
	 * Instantiates a new doubly linked list.
	 */
	public DoublyLinkedList() {

		this.head.setPrev(null);
		this.head.setNext(tail);
		this.tail.setPrev(head);
		this.tail.setNext(null);
	}

	/**
	 * PreCondition : None PostCondition: None All Run Time:Big Theta(1)
	 * 
	 * Adds the char value to end of the linked list.
	 */
	public void addCharAtEnd(char c) {
		last = tail;
		last = last.getPrev();
		DoubleNode temp = new DoubleNode();
		temp.setC(c);
		temp.setNext(tail);
		last.setNext(temp);
		temp.setPrev(last);
		tail.setPrev(temp);
		count++;

	}

	/**
	 * PreCondition : None PostCondition: None All Run Time: Big Theta(1) Adds the char at
	 * front of the linked lists node.
	 * 
	 * @param c
	 *            the c
	 */
	public void addCharAtFront(char c) {

		DoubleNode temp = new DoubleNode();
		temp.setC(c);
		temp.setPrev(head);
		temp.setNext(head.getNext());
		head.getNext().setPrev(temp);
		head.setNext(temp);
		count++;
	}

	/**
	 * PreCondition : None PostCondition: None All Run Time: Big Theta(n)
	 * 
	 * Counts the number of linked lists node.
	 */
	public int countNodes() {
		first = head;
		count = 0;
		while (first != null) {
			first = first.getNext();
			count++;
		}
		return (count - 2);
	}

	/**
	 * PreCondition : None PostCondition: None All Run Time: Big Theta(n) Searches for the
	 * character value and if found deletes the value from the linked lists
	 */
	public boolean deleteChar(char c) {
		boolean found = false;
		first = head;

		while (!found) {
			first = first.getNext();

			if (first.c == c) {
				DoubleNode prev = first.getPrev();
				DoubleNode next = first.getNext();
				next.setPrev(prev);
				prev.setNext(next);
				found = true;
				dchar = true;

			}

		}
		return dchar;
	}

	/**
	 * PreCondition : None PostCondition: None All Run Time: Big Theta(1) Checks to see if the
	 * linked lists is empty or not. Returns true if empty else returns false.
	 * 
	 */
	public boolean isEmpty() {
		first = head;

		if (first.getNext() == tail) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * PreCondition : None PostCondition: None All Run Time: Big Theta(1)
	 * 
	 * Removes Character from end of the linked lists.
	 */
	public char removeCharAtEnd() {
		last = tail;
		last = last.getPrev();
		DoubleNode tmp = last.getPrev();
		tmp.setNext(last.getNext());
		tail.setPrev(last.getPrev());
		return last.c;

	}

	/**
	 * PreCondition : None PostCondition: None All Run Time:Big Theta(1)
	 * 
	 * Removes Character at begining of the linked lists node.
	 */
	public char removeCharFromFront() {
		first = head;
		first = first.getNext();
		temp = first.getNext();
		head.setNext(first.getNext());
		temp.setPrev(first.getPrev());
		return first.c;

	}

	/**
	 * PreCondition : None PostCondition: None All Run Time:Big Theta(n)
	 * 
	 * Reverses the linked lists node.
	 */
	public void reverse() {
		temp1 = null;
		temp = head;

		while (temp != null) {
			temp1 = temp.getNext();
			temp.setNext(temp.getPrev());
			temp.setPrev(temp1);
			temp = temp.getPrev();
		}
		temp1 = head;
		head = tail;
		tail = temp1;

	}

	/**
	 * Converts the contents of the node value to srtring.
	 */
	public String toString() {
		StringBuffer result = new StringBuffer();
		temp = head;
		while (temp != null) {
			result.append(temp.getC());
			temp = temp.getNext();

		}
		return result.toString();
	}

}
