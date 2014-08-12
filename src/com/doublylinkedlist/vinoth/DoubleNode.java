package com.doublylinkedlist.vinoth;

// TODO: Auto-generated Javadoc
/**
 * The Class DoubleNode represents the node of doubly linked lists.
 * 
 * @author Vinoth Rajasekar
 */
public class DoubleNode {

	public DoubleNode prev = null;
	public char c = ' ';
	public DoubleNode next = null;

	/**
	 * Instantiates a new double node.
	 * 
	 * @param p
	 *            references the previous node of the doubly linked lists.
	 * @param ch
	 *            references the data of the node of doubly linked lists.
	 * @param n
	 *            the n
	 */

	public DoubleNode() {

	}

	public DoubleNode(DoubleNode p, char ch, DoubleNode n)

	{
		this.prev = p;
		this.c = ch;
		this.next = n;

	}

	/**
	 * PreCondition : none PostCondition : none All Run time: Big Theta(1)
	 * 
	 * @return the value of the linked lists node.
	 */
	public char getC() {

		return c;
	}

	/**
	 * 
	 * PreCondition : none PostCondition : none All Run time: Big Theta(1)
	 * 
	 * @returns the next node reference in the linked lists.
	 */
	public DoubleNode getNext() {
		return next;
	}

	/**
	 * PreCondition : none PostCondition : none All Run time : Big Theta(1)
	 * 
	 * @returns the previous node reference of the linked lists.
	 */
	public DoubleNode getPrev() {
		return prev;
	}

	/**
	 * PreCondition : none PostCondition : none All Run time: Big Theta(1) sets
	 * the data value of the current linked lists node.
	 */
	public void setC(char c) {

		this.c = c;
	}

	/**
	 * PreCondition : none PostCondition : none All Run time: Big Theta(1) Sets
	 * the reference to the next node in the linked lists.
	 */
	public void setNext(DoubleNode next) {

		this.next = next;
	}

	/**
	 * PreCondition : none PostCondition : none All Run time: Big Theta(1) Sets
	 * the reference to the previous node in the linked lists.
	 */
	public void setPrev(DoubleNode prev) {

		this.prev = prev;

	}

	/**
	 * PreCondition : none PostCondition : none All Run time: Big Theta(1)
	 * converts the data value to strring.
	 */
	@Override
	public String toString()

	{

		return Character.toString(c);

	}

	/**
	 * Test driver for DoubleNode class
	 */
	public static void main(String[] args) {
	}

}
