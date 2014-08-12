package com.hw4.vinoth;


// TODO: Auto-generated Javadoc
/**
 * The Class SingleNode is a singly linked lists holding big integer
 * value.
 */
public class SingleNode {

	/** The data node for the linked lists. */
	private Object data;

	/** The next node for the linked lists. */
	private SingleNode next;
	private int num;

	/**
	 * Constructor.Instantiates a new Single node
	 */
	public SingleNode() {
		data = null;
		next = null;
		num=0;
	}

	/**
	 * Instantiates a new SingleNode
	 * 
	 * @param data
	 *            the data
	 * @param next
	 *            the next
	 */
	public SingleNode(Object data,int num, SingleNode next) {
		this.data = data;
		this.num=num;
		this.next = next;


	}

	public int getNum() {
		return this.num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * PreCondition : None Post Condition: None 
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * @return the data of current linked lists node.
	 */
	public Object getData() {

		return this.data;
	}

	/**
	 * PreCondition : None Post Condition: None  
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * @return Sets the BigInteger value to the current node of the linked
	 *         lists.
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * PreCondition : None Post Condition: None 
	 *BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * 
	 * @returns the references to the next node of the linked lists.
	 */
	public SingleNode getNext() {
		if (this.next == null) {
			return null;
		} else {
			return this.next;
		}
	}

	/**
	 * PreCondition : None Post Condition: None  
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * 
	 * 
	 * Sets the references to the next node that the current node has to refer
	 * to
	 */
	public void setNext(SingleNode next) {
		this.next = next;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.data.toString();
	}

}
