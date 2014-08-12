package com.hw4.vinoth;

import java.io.*;
import java.util.*;

public class GraphExam {
	private HashList Htable;
	private Graph graph;
	@SuppressWarnings("rawtypes")
	private List<ArrayList> grph;
	private boolean[] mark;
	private ArrayList<String> courselist;

	/**
	 * Instantiates a new graph exam.
	 */
	@SuppressWarnings("rawtypes")
	public GraphExam() {
		Htable = new HashList();
		graph = new Graph(20);
		grph = new ArrayList<ArrayList>();
		courselist = new ArrayList<String>();
		mark = null;
	}

	public static void main(String[] args) {
		GraphExam examSchedule = new GraphExam();

		try {
			@SuppressWarnings("resource")
			BufferedReader in = new BufferedReader(new FileReader("inputfile.txt"));

			String line;
			line = in.readLine();

			while (line != null) {
				processLine(line, examSchedule);
				line = in.readLine();
			}
		} catch (IOException e) {
			System.out.println("IO Exception");
		}

		for (int c = 0; c < examSchedule.courselist.size(); c++) {
			System.out.println(c + " " + examSchedule.courselist.get(c));
		}
		System.out.println();

		examSchedule.graph.adjustSize(examSchedule.Htable.getCount());

		examSchedule.mark = new boolean[examSchedule.graph.getSize()];

		examSchedule.graph.printMatrix();

		System.out.println();

		examSchedule.greedy();

		for (int p = 0; p < examSchedule.grph.size(); p++) {
			System.out.print("Final Exam Period " + (p + 1) + " :");
			for (int w = 0; w < examSchedule.grph.get(p).size(); w++) {
				System.out
						.print(" "
								+ examSchedule.courselist
										.get((Integer) examSchedule.grph.get(p)
												.get(w)));
			}
			System.out.print("\n");
		}
	}

	public static void processLine(String line, GraphExam schedule) {

		StringTokenizer st;

		st = new StringTokenizer(line, " ");

		@SuppressWarnings("unused")
		String name = st.nextToken();
		int courseNum = Integer.parseInt(st.nextToken());

		int[] courseindex = new int[courseNum];
		int d = 0;
		while (st.hasMoreTokens()) {
			String coursename = st.nextToken();
			if (schedule.Htable.addCourse(coursename))
				schedule.courselist.add(coursename);
			courseindex[d] = schedule.courselist.indexOf(coursename);
			d++;
		}
		for (int i = 0; i < courseNum; i++) {
			for (int j = i + 1; j < courseNum; j++) {
				schedule.graph.addEdge(courseindex[i], courseindex[j]);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void greedy() {
		grph.add(new ArrayList<Integer>());
		for (int v = 0; v < mark.length; v++) {
			boolean found = false;
			for (int p = 0; p < grph.size(); p++) {
				found = false;
				for (int w = 0; w < grph.get(p).size(); w++) {
					if (graph.isEdge(v,
							((Integer) grph.get(p).get(w)).intValue())) {
						found = true;
						break;
					}
				}
				if (!found) {
					grph.get(p).add(new Integer(v));
					break;
				}
			}
			if (found) {
				ArrayList<Integer> newperiod = new ArrayList<Integer>();

				newperiod.add(new Integer(v));
				grph.add(newperiod);
			}
			mark[v] = true;
		}
	}

}