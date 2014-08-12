package com.hw4.vinoth;

// TODO: Auto-generated Javadoc
/**
 * The Class Graph.
 */
public class Graph {

	/** The edges. */
	private int[][] edges;

	/** The size. */
	private int size;

	/**
	 * Initialize a graph.
	 */
	public Graph() {
	}

	/**
	 * Initialize a graph with n vertices and null labels 
	 * Precondition n >=0;
	 * @param size
	 *            the number of vertices in the graph.
	 */
	public Graph(int size) {
		this.size = size;
		edges = new int[size][size];
	}

	/**
	 * Gets the size of vertices in the graph.
	 * Precondition - None
	 * Post Condition - To get the number of vertices in the graph.
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * 
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size of the vertices in the graph.
     * Precondition - None
	 * Post Condition - set the number of vertices in the graph.
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * 
	 * @param size
	 *            the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Adds the edge to the vertices in the graph
	 * Precondition - None
	 * Post Condition - Marks the edge between the graph.
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * 
	 * @param i
	 *            i the vertex number of the source of the edge.
	 * @param j
	 *            j the vertex number of the target of the edge.
	 */
	public void addEdge(int i, int j) {
		edges[i][j] = 1;
		edges[j][i] = 1;
	}

	/**
	 * Checks if there is a edge between two vertices
	 * 	Precondition - None
	 * Post Condition - returns true if there is edge between two vertices in the graph.
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * 
	 * @param i
	 *            i the vertex number of the source of the edge
	 * @param j
	 *            the vertex number of the target of the edge.
	 * @return true, if is edge
	 */
	public boolean isEdge(int i, int j) {
		if (edges[i][j] == 1)
			return true;
		else
			return false;
	}

	/**
	 * Adjust size of the graph.
	 * Precondition - The num should be greater than zero.
	 * Post Condition - Returns the new number of vertices in the graph.
	 * BestCase RunTime  - BigTheta (n*n)
	 * Worst Case Runtime - BigTheta (n*n)
	 * 
	 * @param num
	 *            the num
	 */
	public void adjustSize(int num) {
		int[][] newEdges = new int[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++)
				newEdges[i][j] = edges[i][j];
		}
		edges = newEdges;
		size = num;
	}

	/**
	 * Prints the matrix.
	 * Precondition - the graph should be non-empty
	 * Post Condition - prints the graph as adjacent matrix.
	 * BestCase RunTime  - BigTheta (n*n)
	 * Worst Case Runtime - BigTheta (n*n)
	 */
	public void printMatrix() {
		System.out.print("    |");
		for (int i = 0; i < size; i++)
			System.out.print(" " + i + "   ");
		System.out.print("\n");
		for (int i = 0; i < size + 1; i++)
			System.out.print("-----");
		System.out.print("\n");
		for (int i = 0; i < size; i++) {
			System.out.print(" " + i + "  |");
			for (int j = 0; j < size; j++) {
				System.out.print(" " + edges[i][j] + "   ");
			}
			System.out.print("\n");
		}
	}

}
