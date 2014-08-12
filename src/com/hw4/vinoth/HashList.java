package com.hw4.vinoth;

// TODO: Auto-generated Javadoc
/**
 * The Class HashList.
 */
public class HashList {

	/** The table size. */
	private final int tableSize = 31;
	
	/** The hash table. */
	private SingleLinkedList[] hashTable;
	
	/** The count. */
	private int count;

	/**
	 * Intialize the hash list.
	 */
	public HashList() {
		hashTable = new SingleLinkedList[tableSize];
		count = 0;
	}

	/**
	 * The hash function is used to set the hash index in the linked lists.
	 * Precondition - The linked list should be constructed.
	 * Post Condition - Assigns the hash index in the linked lists.
	 * BestCase RunTime  - BigTheta (n)
	 * Worst Case Runtime - BigTheta (n)
	 *
	 * @param x the course name
	 * @return the integer for hash index.
	 */
	public int hash(String x) {
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum = sum + (int) x.charAt(i);

		}
		return sum % tableSize;
	}

	/**
	 * Adds the course to the list. if the course already exists, then
	 * it delete them and add the same course in front of the list.
	 * Precondition - The linked list should be constructed.
	 * Post Condition - Adds the course to the list.
	 * BestCase RunTime  - BigTheta (n)
	 * Worst Case Runtime - BigTheta (n)
	 *
	 * @param course the course
	 * @return true, if successful
	 */
	public boolean addCourse(String course) {
		int index = hash(course);
		SingleLinkedList list = hashTable[index];
		
		if (list == null) {
			hashTable[index] = new SingleLinkedList();
			hashTable[index].addNode(course, count);
			
			count++;
			return true;
		} else {

			int num = list.removeNode(course);
			 if(num==-1){
                 list.addNode(course, count);
                 count++;
                 return true;
         }
         else {
			list.addNode(course, num);
			return false;
         }
		}
	}

	/**
	 * Gets the count of the course in the has table.
	 * Precondition - The has table should be built and the courses are added.
	 * Post Condition - returns the count of the course added to the list.
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * sets the count of the course in the has table.
	 * Precondition - The has table should be built and the courses are added.
	 * Post Condition - returns the count of the course added to the list.
	 * BestCase RunTime  - BigTheta (1)
	 * Worst Case Runtime - BigTheta (1)
	 *
	 * @param count the new count
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
