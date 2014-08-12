import java.util.Arrays;


public class Greedy {

	   private int[] color;
	    private int size;
	    private boolean [][] Gmatrix;
	    //private int kColors = 3;
	    
	    public Greedy(){
	    	
	    }
		
		public Greedy(int size){
			color = new int[size];
			this.size = size;
			Gmatrix = new boolean [size][size];
			
		}
		
	    public int getSize() {
	        return size;
	}
	    
	    public void setSize(int size) {
	        this.size = size;
	}
	    public void addEdge(int i,int j){
	        Gmatrix[i][j]=true;
	        Gmatrix[j][i]=true;
	}
	    
	    public boolean isEdge(int i,int j){
	        return Gmatrix[i][j];
	}
		
		
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
	                System.out.print(" "+Gmatrix[i][j]+"  ");
	        }
	        System.out.print("\n");
	        }
	}
	    
	    
	    public boolean kColorable(int k ){
            if(mincolors(color))return true;//check when all vertex are painted in one same color 0.
            int p=1;
            int max=(int)Math.pow(k, size);//counting in base 3, max will have 3^n possible coloring solution
            while(p<max){
            	    //int i = k;
                    //color[i]++;//count one for each time
                  // System.out.println("mx1:" + color[i]);
                    int i=0;
                    while(color[i] > k + 1 ){//deal with carry
                            color[i] = 0;
                            i = i+1;
                            color[i]++;
                           
                           
                    }
                   
                   
                   if(mincolors(color))return true;//check the current color solution; if it works, return true
                    p++;
                    //System.out.print("value:" + p);
            }
            return false;//if not find a solution,means not 3 colorable,return false
    }
    
    public boolean mincolors(int[] mincolor){
    //	for(int i = 0; i < mincolor.length; i++){
  	  // System.out.println(Arrays.toString(mincolor));}
        for(int i = 0; i < mincolor.length; i++){
                for(int w = 0; w < mincolor.length; w++){
                	//System.out.println(i + "," + w);
                        if(isEdge(i,w) && (mincolor[i] == mincolor[w])){
                        	
                                return false;
                                
                        }
                }
        }
        System.out.println("true:" + 1);
        return true;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Greedy g = new Greedy(4);
	       
	       g.addEdge(1, 2);
	       g.addEdge(0, 1);
	       g.addEdge(0, 2);
	       g.addEdge(3, 1);
	       g.addEdge(3, 2);
	       g.addEdge(3, 0);
	       g.printEdges();

	       int kColors = 3;
	       
	       if(g.kColorable(kColors)) {
		          System.out.println("Found coloring with "+ kColors + " colors" );
		           for(int v=0;v<g.size;v++){
	                  System.out.println("Color Vertex "+v+" the color "+g.color[v]);
		          }
		        }
		        else{
		        
		        	System.out.println((kColors) + " colors is not enough");
		 	          }
		        }
		        	
	   }



