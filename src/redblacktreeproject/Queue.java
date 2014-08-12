package redblacktreeproject;

// TODO: Auto-generated Javadoc
/**
 * Implementaion of Circular Queue
 * @author Vinoth Rajasekar
 */
public class Queue {

	/** The Queue data. */
	private Object[] data;

	/** The Queue front. */
	private int front = 0;

	/** The Queue rear. */
	private int rear = 0;

	/** The capacity of the Queue . */
	private int capacity = 10000;

	/** Queue empty checker. */
	private static boolean isEmpty;

	/**
	 * Instantiates a new queue.
	 */
	public Queue() {
		front = 0;
		rear = 0;
		data = new Object[capacity];
		isEmpty = true;
	}

	/**
	 * Dequeue returns data from front of the queue.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return the deQueue object
	 */
	public Object deQueue() {
		if (isEmpty) {
			System.out.println("Queue is empty");
		}

		Object currentData = data[front];

		if (front == data.length - 1) {
			front = 0;
		} else {
			front++;
		}

		if (front == rear) {
			isEmpty = true;
		}
		return currentData;
	}

	/**
	 * Enqueue. Adds an object to the rear of the queue.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @param x the object that is added to rear of the queue.
	 */
	public void enQueue(Object x) {

        if (front == rear && isEmpty == false) {
            System.out.println("Queue is full");
            return;
        }
		data[rear] = x;

		if (front == rear) {
			isEmpty = false;
		}

		if (rear == data.length - 1) {
			rear = 0;
		} else {
			rear++;
		}
	}

	/**
	 * Gets the front of the queue without removing the object
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return the object in the front of the queue
	 */
	public Object getFront() {
		if (isEmpty) {
			return null;
		} 
			return data[front];
	}

	/**
	 * Checks if is empty and returns true if it's not empty, else false.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return true, if it's not empty else false.
	 */
	public boolean isEmpty() {
		return Queue.isEmpty;
	}

	/*
	 * Returns the String Representation of Queue contents.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		int que = front;
		StringBuilder items = new StringBuilder();

		if (isEmpty) {
			items.append("the list is empty");
			return items.toString();

		}

		while (que == rear) {
			items.append(data[que].toString()).append(", ");
			if (que == data.length - 1) {
				que = 0;
			} else {
				que++;

			}
		}

		return items.toString();
	}

	/**
	 * The main method & test driver.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
	}
}
