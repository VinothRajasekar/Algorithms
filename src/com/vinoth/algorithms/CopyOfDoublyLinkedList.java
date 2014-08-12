package com.vinoth.algorithms;

import com.doublylinkedlist.vinoth.DoubleNode;

// TODO: Auto-generated Javadoc
/**
 * The Class DoublyLinkedList.
 */
public class CopyOfDoublyLinkedList {

	

	
	private DoubleNode data;
	
    private DoubleNode head = new DoubleNode();
    private DoubleNode tail = new DoubleNode();
	
	private char c;
	
	private int count = 0;

	private int i;
	

	/**
	 * Instantiates a new doubly linked list.
	 */
	public CopyOfDoublyLinkedList()
	{
	
		this.head.setPrev(null);
		this.head.setNext(tail);
		this.tail.setPrev(head);
		this.tail.setNext(null);
	}
	
	/**
	 * Adds the char at end.
	 *
	 * @param c the c
	 */
	public void addCharAtEnd(char c)
	{
		

		
		
	}
	
	/**
	 * Adds the char at front.
	 *
	 * @param c the c
	 */
	public void addCharAtFront(char c)
	{
		
		DoubleNode temp = new DoubleNode();
		temp.setC(c);
		System.out.println("show:" + c);
		temp.setPrev(head);
		temp.setNext(head.getNext());
		head.getNext().setPrev(temp);
		head.setNext(temp);
		count++;
	}
	
	/**
	 * Count nodes.
	 *
	 * @return the int
	 */
	public int countNodes()
	{

		return count;
	}
	
	/**
	 * Delete char.
	 *
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean deleteChar(char c)
	{
	   return true;
	}
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty()
	{
		return true;
	}
	
	/**
	 * Removes the char at end.
	 *
	 * @return the char
	 */
	public char removeCharAtEnd()
	{
		return c;
	    
	}
	
	/**
	 * Removes the char from front.
	 *
	 * @return the char
	 */
	public char removeCharFromFront()
	{
		return c;
	
	}
	
	/**
	 * Reverse.
	 */
	public void reverse()
	{
		
	}	
	
	
}
