package com.Merkle.vinoth;

import java.math.BigInteger;

// TODO: Auto-generated Javadoc
/**
 * The Class MerkleLinkedLists.
 */
public class MerkleLinkedLists {

	/** The head of the node. */
	private MerkleBigInteger head;

	/** The tail of the node. */
	private MerkleBigInteger tail;

	/** The first node refers to the head node. */
	private MerkleBigInteger first;

	/** The prev is used as a temp node. */
	private MerkleBigInteger prev;

	/**
	 * Constructor Instantiates a new merkle linked lists.
	 */
	public MerkleLinkedLists() {
		this.head = null;
		this.tail = null;
	}

	/**
	 * PreCondition : None Post Condition: None All RunTime - BigTheta (1) The Big
	 * Integer data value will be added to the node of linked lists.
	 * 
	 */
	public void addNode(BigInteger number) {
		MerkleBigInteger newNode = new MerkleBigInteger(number, null);

		if (head == null)

		{
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}

	}

	/**
	 * PreCondition : None Post Condition: None All RunTime - BigTheta (1)
	 * 
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
	 * PreCondition : None Post Condition: None All RunTime - BigTheta (n)
	 * 
	 * 
	 * counts the number of available node in the linked lists.
	 */
	public int countNodes() {

		int count = 0;
		if (this.head == null) {
			return 0;
		}

		first = head;
		while (first != null) {
			first.getNext();
			count++;
		}
		return count;

	}

	/**
	 * PreCondition : The linked list should be non-empty. Post Condition: None
	 * Best RunTime - BigTheta (1) Worst RunTime - BigTheta(n)
	 * 
	 * @param number
	 *            the number
	 * @return true, if successful
	 */
	public boolean removeNode(BigInteger number)

	{

		if (this.head == null) {
			return false;
		}

		boolean found = false;

		first = head;

		while (!found) {
			first = first.getNext();

			if (first.getData() == number) {
				prev = first.getNext();
				prev.setNext(first.getNext());
				found = true;
			}

			prev = first;
		}
		return false;
	}

	/**
	 * PreCondition : The linked lists should be non-empty Post Condition: None
	 * Best RunTime - BigTheta (1) Worst RunTime - BigTheta (n)
	 * 
	 * @returns the index of the node
	 */
	public MerkleBigInteger getIndex(int index) {
		if (head == null) {
			return null;
		}

		MerkleBigInteger iterator = head;
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

		MerkleBigInteger iterator = this.head;

		if (iterator == null) {
			add.append("null");
			return add.toString();
		}

		do {
			add.append(iterator.getData()).append(", ");
		} while ((iterator = iterator.getNext()) != null);

		add.deleteCharAt(add.length() - 2);

		return add.toString();
	}
}
