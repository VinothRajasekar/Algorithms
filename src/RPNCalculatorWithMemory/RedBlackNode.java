package RPNCalculatorWithMemory;


public class RedBlackNode {

	/** The data of the node. */
	private Float data;

	/** Represents the color of the node */
	private int color;

	/** Represents the Parent of the node. */
	private RedBlackNode parent;

	/** Represents the left child of the node. */
	private RedBlackNode lchild;

	/** Represents the right child of the node */
	private RedBlackNode rchild;

	/** Represents color of the node. */
	public static int BLACK = 0;

	/** represents the color of the niode */
	public static int RED = 1;
	
	private String key;

	/**
	 * Instantiates a new red black node.
	 * 
	 * @param data
	 *            the data of the node.
	 * @param color
	 *            the color of the node
	 * @param p
	 *            the parent of the node
	 * @param lc
	 *            the left child of the node
	 * @param rc
	 *            the right child of the node
	 */
	public RedBlackNode(Float data, int color, RedBlackNode p,
			RedBlackNode lc, RedBlackNode rc,String key) {
		this.data = data;
		this.color = color;
		this.parent = p;
		this.lchild = lc;
		this.rchild = rc;
		this.key = key;

	}
	/**
	 * The getData() method returns the data in the node.
	 * @return the data value in the node
	 */
	        public String getKey() {
	                return key;
	        }
	/**
	 * The setData() method sets the data or key of the RedBlackNode. 
	 * @param data is an int holding a node's data value
	 */
	        public void setKey(String key) {
	                this.key = key;
	        }

	/**
	 * Returns the color of the node.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * @return the color
	 */
	public int getColor() {

		return this.color;
	}

	/**
	 * Gets the data of the node
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return the data
	 */
	public Float getData() {
      	return this.data;
	  }

	/**
	 * Gets the left child of the node
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return the left child of the node
	 */
	public RedBlackNode getLc() {
		return this.lchild;
	}

	/**
	 * Gets the right child of the node.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return the right child of the node
	 */
	public RedBlackNode getRc() {
		return this.rchild;
	}

	/**
	 * Gets the parent of the node
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return the parent of the node.
	 */
	public RedBlackNode getP() {
		return this.parent;
	}

	/**
	 * Sets the color of the node.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @param color
	 *            sets the the new color for the node
	 *            Either RED or BLACK
	 */
	public void setColor(int color) {

		this.color = color;
	}

	/**
	 * Sets the current data of the node.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @param data
	 *            the new data
	 */
	public void setData(Float data) {

	    this.data = data;
	 }

	/**
	 * Sets the left child of the node
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @param lc
	 *            the new left child of the node
	 */
	public void setLc(RedBlackNode lc) {

		this.lchild = lc;
	}

	/**
	 * Sets the parent of the node
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @param p
	 *        the new parent of the node.
	 */
	public void setP(RedBlackNode p) {

		this.parent = p;
	}

	/**
	 * Sets the right child of the node.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @param rc
	 *       the new right child of the node
	 */
	public void setRc(RedBlackNode rc) {

		this.rchild = rc;
	}

	/**
	 * String representation of the node.
	 * Run Time Best Case:  Big Theta(1)
	 * Run Time Worst Case: Big Theta(1)
	 * 
	 * @return contents of the node in String format.
	 */
    @Override
	public String toString() {

		StringBuilder data= new StringBuilder();
		data.append("[data=").append(this.data).append(":Color=")
				.append(this.color == BLACK ? "Black" : "Red")
				.append(":Parent=").append(this.parent.getData())
				.append(":LC=").append(this.lchild.getData())
				.append(":RC=").append(this.rchild.getData()).append("]");
		return data.toString();
	}
}
