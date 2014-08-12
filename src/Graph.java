
import java.math.*;
import java.util.Arrays;

public class Graph {
        private boolean[][] Matrix;
        private int size;
        private int[] color;
        
        
        public Graph(){ 
        }
        /**
         * Class constructor, initial the number of vertex in the graph<br>
         * @param size- the number of vertex in the graph <br>
         * pre-condition:none<br>
         * post-condition:Constructor an instance of this Class with initialed fields<br>
         * best case: Theta(1)<br>
         * worst case: Theta(1)<br>
         */
        public Graph(int size){
                this.size=size;
                Matrix=new boolean[size][size];
                color=new int[size];
        }
                
        /**
         * Get the number of vertex in the graph <br>
         * @return the number of vertex in the graph <br>
         * pre-condition:none<br>
         * post-condition:Get the number of vertex in the graph <br>
         * best case: Theta(1)<br>
         * worst case: Theta(1)<br>
         */
        public int getSize() {
                return size;
        }
        /**
         * Set the number of vertex in the graph <br>
         * @param size the number of vertex in the graph <br>
         * pre-condition:none<br>
         * post-condition:Set the number of vertex in the graph <br>
         * best case: Theta(1)<br>
         * worst case: Theta(1)<br>
         */
        public void setSize(int size) {
                this.size = size;
        }
        /**
         * Mark in the Matrix that this is an edge between specific two vertex<br>
         * @param i one of the vertexes<br>
         * @param j the other vertex<br>
         * pre-condition:none<br>
         * post-condition:mark a new edge in adjacency matrix<br>
         * best case: Theta(1)<br>
         * worst case: Theta(1)<br>
         */
        public void addEdge(int i,int j){
                Matrix[i][j]=true;
                Matrix[j][i]=true;
        }
        

        /**
         * Print the adjacency matrix<br>
         * pre-condition:none<br>
         * post-condition:matrix printed<br>
         * best case: Theta(n*n) n is the number of vertax in the graph<br>
         * worst case: Theta(n*n) n is the number of vertax in the graph<br>
         * 
         */
        public void printEdges(){
                System.out.print("   |");
                for(int i=0;i<size;i++)
                        System.out.print(" "+i+"      ");
                System.out.print("\n");
                for(int i=0;i<size+1;i++)
                        System.out.print("-------");
                System.out.print("\n");
                for(int i=0;i<size;i++){
                System.out.print(" "+i+" |");
                for(int j=0;j<size;j++){
                        System.out.print(" "+Matrix[i][j]+"  ");
                }
                System.out.print("\n");
                }
        }
        /**
         * Check whether this is an edge between two specific vertexes<br>
         * @param i one vertex<br>
         * @param j the other vertex<br>
         * @return true or false there is an edge between these two vertexes<br>
         * pre-condition:none<br>
         * post-condition:return true or false there is an edge between these two vertexes<br>
         * best case: Theta(1)<br>
         * worst case: Theta(1)<br>
         */
        public boolean hasEdge(int i,int j){
                return Matrix[i][j];
        }
        
        
        
        /**
         * This method is counting in base 3. It will try all possibility using 3 colors,
         * if any solution works, it proves to be three colorable.
         * @return true or false the graph can be colored by 3 colors
         * worstcase: Omege((3^n)*(n^2))
         * 
         * What I learn: The counting in base 3 will check every possible solution using 3 colors,
         * so, it could find the answer but slow, because some solutions are basically same, such as 0000,1111,2222 
         * or 0100, 0200, but it still check through them, so it contains many unnecessary trials.
         * For the greedy method we used in park1, after it colors one vertex, it will not change its color,
         * so if we find we colored wrong we can not go back to recolor, and we can only try some of all possibility,
         * that's why the greedy method may not useful in part2. 
         * 
         * 
         */
        public boolean threeColorable(){
                if(checkColoring(color))return true;//check when all vertex are painted in one same color 0.
                int p=1;
                int max=(int)Math.pow(3, size);//counting in base 3, max will have 3^n possible coloring solution
                while(p<max){
                        color[0]++;//count one for each time
                        int i=0;
                        while(color[i]>2){//deal with carry
                                color[i] = 0;
                                i = i+1;
                                color[i]++;
                        }
                        
                       // if(checkColoring(color)){
                        //	System.out.println("Print true");
                       // }
                        if(checkColoring(color))return true;//check the current color solution; if it works, return true
                        p++;
                }
                return false;//if not find a solution,means not 3 colorable,return false
        }
        
        /**
         * Check whether the current color solution can successfully paint the graph.
         * We will go through every vertex, for each vertex, if it is in same color with its neighbors,
         * then return false. and if all vertex in current color will not conflict with its neighbors, return true.
         * @param ccolor the int array stores the current color result
         * @return true of false the graph is finish painting successfully
         * worstcase: Omega(n^2)
         */
        public boolean checkColoring(int[] ccolor){
       // 	for(int i = 0; i < ccolor.length; i++){
        //	    System.out.println(Arrays.toString(ccolor));
        	//}
                for(int i = 0; i < ccolor.length; i++){
                        for(int w = 0; w < ccolor.length; w++){
                        	//System.out.println(i + "," + w);
                                if(hasEdge(i,w) && (ccolor[i] == ccolor[w])){
                                	//System.out.println(i + ",false" + w);
                                        return false;
                                }
                        }
                }
                return true;
        }

        
        
        public static void main(String []args){
                System.out.println("Test 1 \n");
                Graph g1 = new Graph(5);
               g1.addEdge(0, 1);
               g1.addEdge(0, 2);
               g1.addEdge(1,4);
               g1.addEdge(2,4);
               g1.addEdge(1, 3);
               g1.addEdge(2, 3);
               g1.addEdge(3,4);
               g1.printEdges();
               System.out.println();

               if(g1.threeColorable()) {
                   System.out.println("Found a coloring");
                   System.out.println("Colors");
                   for(int v=0;v<g1.size;v++){
                           System.out.println("Color Vertex "+v+" : "+g1.color[v]);
                   }
                   System.out.println("Three colors does it");
                   
                }
                else {
                       System.out.println("Three colors is not enough");
               }
               System.out.println();
               
               
               System.out.println("Test 2 \n");                 
               Graph g2 = new Graph(4);
               g2.addEdge(0, 1);
               g2.addEdge(0, 2);
               g2.addEdge(0,3);
               g2.addEdge(1,2);
               g2.addEdge(1,3);
               g2.addEdge(2,3);
               g2.printEdges();
               System.out.println();

               if(g2.threeColorable()) {
                   System.out.println("Found a coloring");
                   System.out.println("Colors");
                   for(int v=0;v<g2.size;v++){
                           System.out.println("Color Vertex "+v+" : "+g2.color[v]);
                   }
                   System.out.println("Three colors does it");
                   
                }
                else {
                       System.out.println("Three colors is not enough");
               }
               
               
               
               System.out.println();
               System.out.println("Test 3 \n");
                   Graph g3 = new Graph(5);
               g3.addEdge(0, 1);
               g3.addEdge(0, 2);
               g3.addEdge(0, 3);
               g3.addEdge(1,4);
               g3.addEdge(2,4);
               g3.addEdge(1, 3);
               g3.addEdge(2, 3);
               g3.addEdge(3,4);
               g3.printEdges();
               System.out.println();

               if(g3.threeColorable()) {
                   System.out.println("Found a coloring");
                   System.out.println("Colors");
                   for(int v=0;v<g3.size;v++){
                           System.out.println("Color Vertex "+v+" : "+g3.color[v]);
                   }
                   System.out.println("Three colors does it");
                   
                }
                else {
                       System.out.println("Three colors is not enough");
               }
               
               
               System.out.println();
               System.out.println("Test 4 \n");
                   Graph g4 = new Graph(6);
               g4.addEdge(0, 1);
               g4.addEdge(0, 2);
               g4.addEdge(1, 3);
               g4.addEdge(1,5);
               g4.addEdge(2,3);
               g4.addEdge(2,4);
               g4.addEdge(4,5);
               g4.printEdges();
               System.out.println();

               if(g4.threeColorable()) {
                   System.out.println("Found a coloring");
                   System.out.println("Colors");
                   for(int v=0;v<g4.size;v++){
                           System.out.println("Color Vertex "+v+" : "+g4.color[v]);
                   }
                   System.out.println("Three colors does it");
                   
                }
                else {
                       System.out.println("Three colors is not enough");
               }
               
               System.out.println();
               System.out.println("Test 5 \n");
                   Graph g5 = new Graph(6);
               g5.addEdge(0, 1);
               g5.addEdge(0, 2);
               g5.addEdge(0,3);
               g5.addEdge(1, 3);
               g5.addEdge(1,4);
               g5.addEdge(1,5);
               g5.addEdge(2,3);
               g5.addEdge(2,4);
               g5.addEdge(2, 3);
               g5.addEdge(3,4);
               g5.addEdge(4,5);
               g5.printEdges();
               System.out.println();

               if(g5.threeColorable()) {
                   System.out.println("Found a coloring");
                   System.out.println("Colors");
                   for(int v=0;v<g5.size;v++){
                           System.out.println("Color Vertex "+v+" : "+g5.color[v]);
                   }
                   System.out.println("Three colors does it");
                   
                }
                else {
                       System.out.println("Three colors is not enough");
               }
           }

        }
