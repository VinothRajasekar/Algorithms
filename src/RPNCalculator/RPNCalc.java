package RPNCalculator;

import java.util.EmptyStackException;
import java.util.Stack;

// TODO: Auto-generated Javadoc
/**
 * The Class RPNCalc.
 */
public class RPNCalc {

	/** The stack variable. */
	private Stack<Float> st;

	/**
	 * Instantiates a new RPN calc.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RPNCalc() {

		st = new Stack();

	}

	/**
	 * Adds the given item to the top of the stack precondition:have two
	 * operands can be popped up<br>
	 * postcondition:execute the operation and put the result back to stack<br>
	 * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 */
	public void add() {

		try {

			float first = st.pop();
			float second = st.pop();
			float third = first + second;
			st.push(third);
		} catch (EmptyStackException ee) {
			System.out
					.println("No elements on the stack to perform the operation.");
		}
	}

	/**
	 * Divides the given item to the top of the stack precondition:have two
	 * operands can be popped up<br>
	 * postcondition:execute the operation and put the result back to stack<br>
	 * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 */
	public void divide() {

		try {

			float first = st.pop();
			float second = st.pop();
			float third = second / first;
			st.push(third);
		} catch (EmptyStackException ee) {
			System.out
					.println("No elements on the stack to perform the operation.");
		}

	}

	/**
	 * Multiplies the given item to the top of the stack precondition:have two
	 * operands can be popped up<br>
	 * postcondition:execute the operation and put the result back to stack<br>
	 * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 */
	public void multiply() {
		try {
			float first = st.pop();
			float second = st.pop();
			float third = first * second;
			st.push(third);
		} catch (EmptyStackException ee) {
			System.out
					.println("No elements on the stack to perform the operation.");
		}

	}

	/**
	 * Subtract the given item to the top of the stack precondition:have two
	 * operands can be popped up<br>
	 * postcondition:execute the operation and put the result back to stack<br>
	 * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 */
	public void subtract()

	{
		try {
			float first = st.pop();
			float second = st.pop();
			float third = second - first;
			st.push(third);
		} catch (EmptyStackException ee) {
			System.out
					.println("No elements on the stack to perform the operation.");
		}
	}

	/**
	 * Adds item to top of the stack precondition:none<br>
	 * postcondition:put the number into the stack<br>
	 * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 * 
	 * @param item
	 *            the item
	 */
	public void number(float item) {
		try {

			st.push(item);
		} catch (EmptyStackException ee) {
			System.out
					.println("No elements on the stack to perform the operation.");
		}

	}

	/**
	 * Returns top of the element of the stack, but doesn't removes it.
	 * precondition:none<br>
	 * postcondition:get the top number on the stack<br>
	 * bestcase:Theta(1)<br>
	 * worstcase:Theta(1)<br>
	 * 
	 * @return the float
	 */
	public float top() {
		try {
			float pk = st.peek();
			return pk;
		} catch (EmptyStackException ee) {
			System.out
					.println("No elements on the stack to perform the operation.");
			return 0;
		}
	}

}
