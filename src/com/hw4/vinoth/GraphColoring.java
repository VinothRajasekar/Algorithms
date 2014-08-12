package com.hw4.vinoth;

// TODO: Auto-generated Javadoc
/**
 * The Class GraphColoring.
 */
public class GraphColoring {

	/** The color. */
	public int[] color;
	
	/** The size. */
	public int size;
	
	/** The Gmatrix. */
	private boolean[][] Gmatrix;
	
	/** The q. */
	private static int q = 0;

	/**
	 * Instantiates a new graph coloring.
	 */
	public GraphColoring() {

	}

	/**
	 * Initialize a graph with n vertices and null labels 
	 * Precondition n >=0;
	 * @param size
	 *            the number of vertices in the graph.
	 */
	public GraphColoring(int size) {
		color = new int[size];
		this.size = size;
		Gmatrix = new boolean[size][size];

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
		Gmatrix[i][j] = true;
		Gmatrix[j][i] = true;
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
		return Gmatrix[i][j];
	}

	/**
	 * This method will try to color the vertices with not more than k colors.
	 * The adjacent vertices will not be having the same color.it provides 
	 * optimal k coloring solution. returns true if the graph can be colored
	 * with no more than k colors, else it returns false.
	 * The K base counting will checking all the possible solutions to find
	 * out the optimal coloring. Through many trails of 0000,0001,0010(for k=3)
	 * it checks to see whether the vertex are colorable using these 
	 * combinations. if they are colorable it returns true, else false.
	 * Worst case : Omega((K^n)*(n^2))
	 *
	 * @param k the k
	 * @return true, if successful
	 */
	public boolean kColorable(int k) {
		if (mincolors(color))
			return true;
		int check = 1;
		int max = (int) Math.pow(k, size);
		while (check < max) {
			color[0]++;
			int i = 0;
			while (color[i] > k) {
				color[i] = 0;
				i = i + 1;
				color[i]++;

			}

			if (mincolors(color))
				return true;
			check++;

		}
		return false;
	}

	/**
	 * This method checks whether current color solution
	 * can successfully paint the graph. It will go through each
	 * vertex and if the neighboring vertex has the same colors 
	 * then it returns false.if the neighboring vertex has the different
	 * colors, then it returns true telling the kcolorable method
	 * through how many colors the optimal coloring solution is achieved.
	 *
	 *Worst case : Omega((n^2))
	 * @param mincolor the mincolor
	 * @return true, if successful
	 */
	public boolean mincolors(int[] mincolor) {
		for (int i = 0; i < mincolor.length; i++) {
			for (int w = 0; w < mincolor.length; w++) {
				if (isEdge(i, w) && (mincolor[i] == mincolor[w])) {

					return false;

				}
			}
		}
		return true;
	}

	/**
	 * Prints the matrix.
	 * Precondition - the graph should be non-empty
	 * Post Condition - prints the graph as adjacent matrix.
	 * BestCase RunTime  - BigTheta (n*n)
	 * Worst Case Runtime - BigTheta (n*n)
	 */
	public void printEdges() {
		System.out.print("   |");
		for (int i = 0; i < size; i++)
			System.out.print(" " + i + "      ");
		System.out.print("\n");
		for (int i = 0; i < size + 1; i++)
			System.out.print("-------");
		System.out.print("\n");
		for (int i = 0; i < size; i++) {
			System.out.print(" " + i + " |");
			for (int j = 0; j < size; j++) {
				System.out.print(" " + Gmatrix[i][j] + "  ");
			}
			System.out.print("\n");
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Building a graph");
		System.out.println();
		GraphColoring g = new GraphColoring(4);

		g.addEdge(1, 2);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(3, 1);
		g.addEdge(3, 2);
		g.addEdge(3, 0);
		g.printEdges();
		System.out.println();
		int kColors = 3;

		if (g.kColorable(kColors)) {

			System.out.println("Found coloring with " + (g.size) + " colors");
			for (int v = 0; v < g.size; v++) {
				System.out.println("Color Vertex " + v + " the color "
						+ g.color[v]);
				int s = g.color[v];
				if (q <= s) {
					q = s;
				}
			}
		}

		System.out.println();

		if (q < kColors) {
			System.out.println((kColors) + " colors is enough");

		} else {
			System.out.println((kColors) + " colors is not enough");
		}

		System.out.println();

		GraphColoring g1 = new GraphColoring(5);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 4);
		g1.addEdge(2, 4);
		g1.addEdge(1, 3);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		g1.printEdges();
		System.out.println();

		if (g1.kColorable(kColors)) {

			System.out.println("Found coloring with " + (g1.size) + " colors");
			q = 0;
			for (int v = 0; v < g1.size; v++) {
				System.out.println("Color Vertex " + v + " the color "
						+ g1.color[v]);
				int s = g1.color[v];

				if (q <= s) {
					q = s;
				}
			}
		}

		System.out.println();

		if (q < kColors) {
			System.out.println((kColors) + " colors is enough");

		} else {
			System.out.println((kColors) + " colors is not enough");
		}

		System.out.println();
		GraphColoring g2 = new GraphColoring(6);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 3);
		g2.addEdge(1, 5);
		g2.addEdge(2, 3);
		g2.addEdge(2, 4);
		g2.addEdge(4, 5);
		g2.printEdges();
		System.out.println();

		if (g2.kColorable(kColors)) {

			System.out.println("Found coloring with " + (g2.size) + " colors");
			q = 0;
			for (int v = 0; v < g2.size; v++) {
				System.out.println("Color Vertex " + v + " the color "
						+ g2.color[v]);
				int s = g2.color[v];

				if (q <= s) {
					q = s;
				}
			}
		}

		System.out.println();

		if (q < kColors) {
			System.out.println((kColors) + " colors is enough");

		} else {
			System.out.println((kColors) + " colors is not enough");
		}

	}

}
