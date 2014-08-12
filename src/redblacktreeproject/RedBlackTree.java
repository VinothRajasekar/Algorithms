package redblacktreeproject;

import redblacktreeproject.Queue;
import redblacktreeproject.RedBlackNode;
import redblacktreeproject.RedBlackTree;

/**
* Red black tree implementation.
*
* @author Vinoth Rajasekar
*/
public class RedBlackTree {

    private RedBlackNode root;
    private RedBlackNode leaf;
    private int recentCompares;
    private int numberOfNodes;

    /**
* Default constructor for red black tree.
*/
    public RedBlackTree () {
        root = leaf = new RedBlackNode("-1", RedBlackNode.BLACK, null, null, null);
        recentCompares = 0;
        numberOfNodes = 0;
    }

    /**
* Returns the close by value of v in the tree.
* RunTime best case:Big Theta(1)
* Runtime worst case:Big Theta(log n)
*
* @param The close by value to search v.
* @return returns data in the tree that is closest to v.
*/
    public String closeBy(String v) {
        return getCloseNode(root, v);
    }

    /**
* Returns the v is present in the tree, otherwise false.
* RunTime best case:Big Theta(1)
* Runtime worst case:Big Theta(log n)
*
* @param Searches the value v in the tree.
* @return True if the data is found, false otherwise
*/
    public boolean contains(String v) {
        recentCompares = 0;
        return checkForData(root, v);
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
    public void insert(String value) {
        RedBlackNode z = new RedBlackNode(value, RedBlackNode.RED, null, null, null);
        RedBlackNode y = this.leaf;
        RedBlackNode x = this.root;

        while (x != this.leaf) {
            y = x;
            if (x.getData().compareTo(value) > 0) {
                x = x.getLc();
            } else {
                x = x.getRc();
            }
        }
        z.setP(y);
        if (y == this.leaf) {
            this.root = z;
        } else {
            if (z.getData().compareTo(y.getData()) > 0) {
                y.setRc(z);
            } else {
                y.setLc(z);
            }
        }
        z.setLc(this.leaf);
        z.setRc(this.leaf);
        RBInsertFixup(z);
    }

    /**
* performs level traversal of the tree
* RunTime best case:Big Theta(1)
* Runtime worst case:Big Theta(n)
*/
    public void levelOrderTraversal() {
        Queue nodeList = new Queue();
        RedBlackNode node;
        if (this.root == this.leaf) {
            return;
        }

        nodeList.enQueue(this.root);
        while (!nodeList.isEmpty()) {
            node = (RedBlackNode) nodeList.deQueue();
            System.out.println(node);
            if (node.getLc() != this.leaf) {
                nodeList.enQueue(node.getLc());
            }
            if (node.getRc() != this.leaf) {
                nodeList.enQueue(node.getRc());
            }
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
    private boolean checkForData(RedBlackNode node, String data) {
        if (node == leaf) {
            recentCompares++;
            return false;
        } else if (node.getData().compareTo(data) == 0) {
            recentCompares++;
            return true;
        } else if (node.getData().compareTo(data) < 0) {
            recentCompares++;
            return checkForData(node.getRc(), data);
        } else {
            recentCompares++;
            return checkForData(node.getLc(), data);
        }
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
    private String getCloseNode(RedBlackNode node, String data) {
        String returnData;

        if (node == leaf) {
            return null;
        } else if (node.getData().compareTo(data) == 0) {
            return node.getData();
        } else if (node.getData().compareTo(data) < 0) {
            if ((returnData = getCloseNode(node.getRc(), data)) == null) {
                return node.getData();
            } else {
                return returnData;
            }
        } else {
            if ((returnData = getCloseNode(node.getLc(), data)) == null) {
                return node.getData();
            } else {
                return returnData;
            }
        }
    }

    /**
* Redblack tree test driver
*
* @param args Not used
*/
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        for (int j = 1; j <= 5; j++) {
            rbt.insert("" + j);
        }

        // after 1..5 are inserted
        System.out.println("RBT in order");
        rbt.inOrderTraversal();
        System.out.println("RBT level order");
        rbt.levelOrderTraversal();

        // is 3 in the tree

        if (rbt.contains("" + 3)) {
            System.out.println("Found 3");
        } else {
            System.out.println("No 3 found");
        }

        // display the height
        System.out.println("The height is " + rbt.height());

    }
}






