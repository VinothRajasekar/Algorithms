package RPNCalculatorWithMemory;

public class RedBlackTreeDictionary {

	    private RedBlackNode root;
	    private RedBlackNode leaf;
	    private int recentCompares;
	    private int numberOfNodes;
	    private RedBlackNode currentNode;

	    /**
	* Default constructor for red black tree.
	*/
	    public RedBlackTreeDictionary () {
	        root = leaf = new RedBlackNode(0f, RedBlackNode.BLACK, null, null, null,"-1");
	        recentCompares = 0;
	        numberOfNodes = 0;
	    }

	    /**
	* Returns comparison made with the most recent.
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(1)
	*
	* @return Total Number of comparisons made 
	*/
	    public int getRecentCompares() {
	        return this.recentCompares;
	    }

	    /**
	* Returns number of nodes in the tree.
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(1)
	* @return Number of nodes in the tree.
	*/
	    public int getSize() {
	        return this.numberOfNodes;
	    }

	    /**
	* Returns the height of the tree
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(logn)
	*
	* @return Height of the tree
	*/
	    public int height() {
	        return height(root);
	    }

	    /**
	* performs inorder traversal of the tree,
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(n)
	*/
	    public void inOrderTraversal() {
	        inOrderTraversal(root);
	    }

	    /**
	* Inserts data into the tree.
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(log n)
	* @param value Data to be inserted
	*/
	    public void put(String key,Float value) {
	    	
            if(contains(key))currentNode.setData(value);
            else{
            RedBlackNode y=this.leaf;
            RedBlackNode x=root;
            while (x!=this.leaf){
                    y=x;
                    if(key.compareTo(x.getKey())<0)
                            x=x.getLc();
                    else x=x.getRc();
            }
            RedBlackNode z=new RedBlackNode(value,RedBlackNode.RED,y,null,null,key);
            if (y==this.leaf)
                    root=z;
            else {
                    if (key.compareTo(y.getKey())<0)
                            y.setLc(z);
                    else y.setRc(z);
            }
            z.setLc(this.leaf);
            z.setRc(this.leaf);
            RBInsertFixup(z);
            
            }
	    
    }
	     

	    /**
	* performs leftrotate of the tree.
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(1)
	* @param Node around which left rotation has to be performed
	*/
	    private void leftRotate(RedBlackNode x) {
	        if (x.getRc() == this.leaf) {
	            return;
	        }

	        if (this.root.getP() != this.leaf) {
	            return;
	        }

	        RedBlackNode y = x.getRc();
	        x.setRc(y.getLc());
	        y.getLc().setP(x);
	        y.setP(x.getP());

	        if (x.getP() == this.leaf) {
	            this.root = y;
	        } else {
	            if (x.getP().getLc() == x) {
	                x.getP().setLc(y);
	            } else {
	                x.getP().setRc(y);
	            }
	        }
	        y.setLc(x);
	        x.setP(y);
	    }

	    /**
	* performs right rotation of the tree.
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(1)
	* @param Node around which right rotation has to be performed
	*/
	    private void rightRotate(RedBlackNode x) {
	        if (x.getLc() == this.leaf) {
	            return;
	        }

	        if (this.root.getP() != this.leaf) {
	            return;
	        }

	        RedBlackNode y = x.getLc();
	        x.setLc(y.getRc());
	        y.getRc().setP(x);
	        y.setP(x.getP());

	        if (x.getP() == this.leaf) {
	            this.root = y;
	        } else {
	            if (x.getP().getLc() == x) {
	                x.getP().setLc(y);
	            } else {
	                x.getP().setRc(y);
	            }
	        }
	        y.setRc(x);
	        x.setP(y);
	    }

	    /**
	* performs fix up to preserve the insert contents of the tree.
	* RunTime best case:Big Theta(1)
	* Runtime worst case:Big Theta(logn )
	*
	* @param z is the curent node on which the fixup is performed
	*/
	    private void RBInsertFixup(RedBlackNode z) {
	        RedBlackNode y;
	        while (z.getP().getColor() == RedBlackNode.RED) {
	            if (z.getP().getP().getLc() == z.getP()) {
	                y = z.getP().getP().getRc();
	                if (y.getColor() == RedBlackNode.RED) {
	                    z.getP().setColor(RedBlackNode.BLACK);
	                    y.setColor(RedBlackNode.BLACK);
	                    z.getP().getP().setColor(RedBlackNode.RED);
	                    z = z.getP().getP();
	                } else {
	                    if (z.getP().getRc() == z) {
	                        z = z.getP();
	                        leftRotate(z);
	                    }
	                    z.getP().setColor(RedBlackNode.BLACK);
	                    z.getP().getP().setColor(RedBlackNode.RED);
	                    rightRotate(z.getP().getP());
	                }
	            } else {
	                y = z.getP().getP().getLc();
	                if (y.getColor() == RedBlackNode.RED) {
	                    z.getP().setColor(RedBlackNode.BLACK);
	                    y.setColor(RedBlackNode.BLACK);
	                    z.getP().getP().setColor(RedBlackNode.RED);
	                    z = z.getP().getP();
	                } else {
	                    if (z.getP().getLc() == z) {
	                        z = z.getP();
	                        rightRotate(z);
	                    }
	                    z.getP().setColor(RedBlackNode.BLACK);
	                    z.getP().getP().setColor(RedBlackNode.RED);
	                    leftRotate(z.getP().getP());
	                }
	            }
	        }
	        this.root.setColor(RedBlackNode.BLACK);
	    }

	    /**
	* performs the inorder traversal of the tree.
	* RunTime best case:Big Theta(n)
	* Runtime worst case:Big Theta(n)
	*
	* @param node in which the inorder traversal is performed.
	*/
	    private void inOrderTraversal(RedBlackNode node) {
	        if (node.getLc() != this.leaf) {
	            inOrderTraversal(node.getLc());
	        }
	        System.out.println(node);
	        if (node.getRc() != this.leaf) {
	            inOrderTraversal(node.getRc());
	        }
	    }

	    /**
	* recursive call to determine the height of the tree.
	* RunTime best case:Big Theta(log n)
	* Runtime worst case:Big Theta(log n )
	* 
	* @return Height of the current node
	*/
	    private int height(RedBlackNode node) {
	        if (node == leaf || (node.getLc() == leaf) && (node.getRc() == leaf)) {
	            return 0;
	        }
	        return 1 + Math.max(height(node.getLc()), height(node.getRc()));
	    }

	    /**
	*Checks for the existence of the data in the tree.
	* RunTime best case:Big Theta(log n)
	* Runtime worst case:Big Theta(log n )
	* 
	*
	* @param node is the current being compared
	* @param data Data that is being searched
	* @return returns true if data is found, else false.
	*/
	    public boolean contains(String key) {
	    	  RedBlackNode current=root;
              recentCompares=1;
              while(current!= this.leaf){
                      if(key.compareTo(current.getKey())<0){
                              currentNode=current;
                              current=current.getLc();}
                      else if(key.compareTo(current.getKey())>0){
                              currentNode=current;
                              current=current.getRc();}
                      else if(key.compareTo(current.getKey())==0){
                              currentNode=current;
                              return true;}
                      recentCompares++;
              }
              return false;
      }

	    /**
	*used to find the closest node in the tree
	* RunTime best case:Big Theta(log n)
	* Runtime worst case:Big Theta(log n )
	*
	* @param node Node that is being compared to
	* @param data Data that is being compared
	* @return The closest node if found
	*/
	    
	    public Float get(String key){
	    	//RedBlackNode currentNode = root;
            if(!contains(key)) return null;
            else return currentNode.getData();
	    }

	    /**
	* Redblack tree test driver
	*
	* @param args Not used
	*/
	    public static void main(String[] args) {
	    

	}
}





