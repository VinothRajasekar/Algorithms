package com.Merkle.vinoth;

import java.math.BigInteger;

// TODO: Auto-generated Javadoc
/**
 * The Class MerkleBigInteger is a singly linked lists holding big integer
 * value.
 */
public class MerkleBigInteger {

	/** The data node for the linked lists. */
	private BigInteger data;

	/** The next node for the linked lists. */
	private MerkleBigInteger next;

	/**
	 * Constructor.Instantiates a new merkle big integer node.
	 */
	public MerkleBigInteger() {
		data = null;
		next = null;
	}

	/**
	 * Instantiates a new merkle big integer.
	 * 
	 * @param data
	 *            the data
	 * @param next
	 *            the next
	 */
	public MerkleBigInteger(BigInteger data, MerkleBigInteger next) {
		this.data = data;
		this.next = next;

	}

	/**
	 * PreCondition : None Post Condition: None All RunTime - BigTheta (1)
	 * 
	 * @return the data of current linked lists node.
	 */
	public BigInteger getData() {

		return this.data;
	}

	/**
	 * PreCondition : None Post Condition: None All RunTime - BigTheta (1)
	 * 
	 * @return Sets the BigInteger value to the current node of the linked
	 *         lists.
	 */
	public void setData(BigInteger data) {
		this.data = data;
	}

	/**
	 * PreCondition : None Post Condition: None All RunTime - BigTheta (1)
	 * 
	 * 
	 * @returns the references to the next node of the linked lists.
	 */
	public MerkleBigInteger getNext() {
		if (this.next == null) {
			return null;
		} else {
			return this.next;
		}
	}

	/**
	 * PreCondition : None Post Condition: None All RunTime - BigTheta (1)
	 * 
	 * 
	 * Sets the references to the next node that the current node has to refer
	 * to
	 */
	public void setNext(MerkleBigInteger next) {
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
