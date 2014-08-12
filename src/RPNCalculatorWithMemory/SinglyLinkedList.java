package RPNCalculatorWithMemory;

//TODO: Auto-generated Javadoc
/**
* The Class SinglyLinkedList.
* 
* @param <E>
*            the element type
*/
public class SinglyLinkedList<E> {

	/** The data. */

	private E data;

	/** The link. */
	public SinglyLinkedList<E> link;

	/**
	 * Instantiates a new singly linked list.
	 * 
	 * @param calcData
	 *            the calc data
	 * @param calcLink
	 *            the calc link
	 */
	public SinglyLinkedList(E calcData, SinglyLinkedList<E> calcLink) {
		this.data = calcData;
		this.link = calcLink;
	}

	/**
	 * Modification method to add a new node.
	 * 
	 * @param element
	 *            the data to place in the new node
	 * @postcondition A new node has been created and placed. The data for the
	 *                new node is element. Any other nodes that used to be after
	 *                this node are now after the new node.
	 * @exception OutOfMemoryError
	 *                bestcase:Theta(1)<br>
	 *                worstcase:Theta(1)<br>
	 * 
	 * @param value
	 *            the value
	 */
	public void addNode(E value) {
		link = new SinglyLinkedList<E>(value, link);
	}

	/**
	 * /** PreCondition : none PostCondition : none * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 * 
	 * @return the value of the linked lists node.
	 */
	public E getData() {
		return this.data;
	}

	/**
	 * 
	 * PreCondition : none PostCondition : none * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 * 
	 * @returns the next node reference in the linked lists.
	 */
	public SinglyLinkedList<E> getLink() {
		return this.link;
	}

	/**
	 * PreCondition : none PostCondition : none setsthe data value of the
	 * current linked lists node. * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 */
	public void setData(E newData) {
		this.data = newData;
	}

	/**
	 * PreCondition : none PostCondition : none sets the reference to the next
	 * node in the linked lists. * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 */
	public void setLink(SinglyLinkedList<E> newLink) {
		this.link = newLink;
	}

	/**
	 * precondition:none<br>
	 * postcondition:the data will be removed from the node<br>
	 * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 * Removes the node.
	 */
	public void removeNode() {
		this.link = link.link;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public String toString() {
		return data.toString();

	}

}
