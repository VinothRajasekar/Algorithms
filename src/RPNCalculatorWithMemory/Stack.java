package RPNCalculatorWithMemory;
import java.util.EmptyStackException;

import RPNCalculator.SinglyLinkedList;

//TODO: Auto-generated Javadoc
/**
* The Class Stack.
* 
* @param <E>
*            the element type
*/
public class Stack<E> {

	/** The top. */
	private SinglyLinkedList<E> top;

	/**
	 * Initialize an empty stack.
	 * 
	 * @param - none <dt><b>Postcondition:</b>
	 *        <dd>
	 *        This stack is empty.
	 **/
	public Stack() {
		top = null;

	}

	/**
	 * Determine whether this stack is empty.
	 * 
	 * @param - none
	 * @return <CODE>true</CODE> if this stack is empty; <CODE>false</CODE>
	 *         otherwise. * bestcase:Theta(1)<br>
	 *         worstcase:Theta(1)<br>
	 **/
	public boolean isEmpty() {
		return (top == null);
	}

	/**
	 * Push a new item onto this stack. The new item may be the null reference.
	 * 
	 * @param <CODE>item</CODE> the item to be pushed onto this stack <dt>
	 *        <b>Postcondition:</b>
	 *        <dd>
	 *        The item has been pushed onto this stack.
	 * @exception OutOfMemoryError
	 *                Indicates insufficient memory for increasing the stack's
	 *                capacity. * bestcase:Theta(1)<br>
	 *                worstcase:Theta(1)<br>
	 **/
	public void push(E item) {
		top = new SinglyLinkedList<E>(item, top);
	}

	/**
	 * Get the top item, removing it from this stack.
	 * 
	 * @param - none <dt><b>Precondition:</b>
	 *        <dd>
	 *        This stack is not empty.
	 *        <dt><b>Postcondition:</b>
	 *        <dd>
	 *        The return value is the top item of this stack, and the item has
	 *        been removed.
	 * @exception EmptyStackException
	 *                Indicates that this stack is empty. * bestcase:Theta(1)<br>
	 *                worstcase:Theta(1)<br>
	 **/
	public E pop() {
		E answer;

		if (top == null)
			// EmptyStackException is from java.util and its constructor has no
			// argument.
			throw new EmptyStackException();

		answer = top.getData();
		top = top.getLink();
		return answer;
	}

	/**
	 * Get the top item of this stack, without removing the item.
	 * 
	 * @param - none <dt><b>Precondition:</b>
	 *        <dd>
	 *        This stack is not empty.
	 * @return the top item of the stack
	 * @exception EmptyStackException
	 *                Indicates that this stack is empty. * bestcase:Theta(1)<br>
	 *                worstcase:Theta(1)<br>
	 **/
	public E peek() {
		if (top == null)
			// EmptyStackException is from java.util and its constructor has no
			// argument.
			throw new EmptyStackException();
		return top.getData();
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	// TODO Auto-generated method stub

	public String toString() {
		return top.toString();

	}

}
