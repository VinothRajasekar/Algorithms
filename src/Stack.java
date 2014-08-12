

import java.util.EmptyStackException;


public class Stack<E> {

	/**
	 * @param args
	 */
	private SinglyLinkedList1<E> top;
	
	public Stack()
	{
		top = null;
	}
	
	 public boolean isEmpty( )
	   {
	      return (top == null);
	   }
	 
	  public void push(E item)
	   {
	      top = new SinglyLinkedList1<E>(item, top);
	   }
	
	  public E pop( )
	   {
	      E answer;
	      
	      if (top == null)
	         // EmptyStackException is from java.util and its constructor has no argument.
	         throw new EmptyStackException( );
	      
	      answer = top.getData( );
	      top = top.getLink( );
	      return answer;
	   }    
	  
	  public E peek( )   
	   {
	      if (top == null)
	         // EmptyStackException is from java.util and its constructor has no argument.
	         throw new EmptyStackException( );
	      return top.getData( );
	   }
	 

}
