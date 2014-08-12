package com.hw4.vinoth;

// TODO: Auto-generated Javadoc
/**
 * The Class SingleLinkedList.
 */
public class SingleLinkedList {

	/** The head of the node. */
	private SingleNode head;

	/** The tail of the node. */
	private SingleNode tail;

	/** The first node refers to the head node. */
	private SingleNode first;

	/** The prev is used as a temp node. */
	private SingleNode prev;

	/**
	 * Constructor Instantiates a new Single linked lists.
	 */
	public SingleLinkedList() {
		this.head = null;
		this.tail = null;
	}

	/**
	 * PreCondition : None Post Condition: None BestCase RunTime - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1) Data value will be added to the node of
	 * linked lists.
	 * 
	 * @param count
	 * 
	 */
	public void addNode(Object data, int num) {
		SingleNode newNode = new SingleNode(data, num, null);
		if (head == null)

		{
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;

		}

	}

	/**
	 * PreCondition : None Post Condition: None Worst Case Runtime - BigTheta
	 * (1)
	 * 
	 * @return true, if the linked lists is empty, else returns false.
	 */
	public boolean isEmpty() {

		if (this.head == null) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * PreCondition : None Post Condition: None BestCase RunTime - BigTheta (n)
	 * Worst Case Runtime - BigTheta (n)
	 * 
	 * counts the number of available node in the linked lists.
	 */
	public int countNodes() {

		int count1 = 0;
		if (this.head == null) {
			return 0;
		}

		first = head;
		while (first != null) {
			first.getNext();
			count1++;
		}
		return count1;

	}

	/**
	 * PreCondition : The linked list should be non-empty. Post Condition: None
	 * Best RunTime - BigTheta (1) Worst RunTime - BigTheta(n)
	 * 
	 * @param number
	 *            the number
	 * @return true, if successful
	 */
	public int removeNode(Object data)

	{
		if (this.head == null) {
			return -1;
		} else {

			first = head;

			while (first != null) {

				
				if (first.getData().equals(data) && first.getNext() == null) {
					

					head = tail = null;
					
					return first.getNum();
				}

				else if (first.getData().equals(data)) {
					prev = first.getNext();
					prev.setNext(first.getNext());
					return first.getNum();
				} else
					first = first.getNext();
			}
			
			return -1;

		}

	}

	/**
	 * PreCondition : The linked lists should be non-empty Post Condition: None
	 * Best RunTime - BigTheta (1) Worst RunTime - BigTheta (n)
	 * 
	 * @returns the index of the node
	 */
	public SingleNode getIndex(int index) {
		if (head == null) {
			return null;
		}

		SingleNode iterator = head;
		for (int i = 0; i < index; i++) {
			iterator = iterator.getNext();
			if (iterator == null) {
				return null;
			}
		}
		return iterator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder add = new StringBuilder();

		SingleNode iterator = this.head;

		if (iterator == null) {
			add.append("null");
			return add.toString();
		}

		return add.toString();
	}
}
