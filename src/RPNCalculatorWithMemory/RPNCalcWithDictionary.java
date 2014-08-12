package RPNCalculatorWithMemory;

import java.util.*;

public class RPNCalcWithDictionary {
        @SuppressWarnings("rawtypes")
		private Stack st;
        private RedBlackTreeDictionary TD;
        
        /**
         * Class construct. with initiated empty stack and tree dictionary 
         */
        @SuppressWarnings("rawtypes")
		public RPNCalcWithDictionary(){
                st=new Stack();
                TD=new RedBlackTreeDictionary();
        }
        
        /**
         * Adds the given item to the top of the stack
         * precondition:have two operands can be popped up<br>
         * postcondition:execute the operation and put the result back to stack<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(log(n))<br>
         */
        @SuppressWarnings("unchecked")
		public void add(){
                try{
                Float second=getvalue(st.pop());
                Float first=getvalue(st.pop());
                st.push(first+second);
                }catch(EmptyStackException ee){
                        System.out.println("There are not enough elements on the stack to perform the operation.");
                }
        }
        /**
         * subtracts the given item to the top of the stack
         * precondition:have two operands can be popped up<br>
         * postcondition:execute the operation and put the result back to stack<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(log(n))<br>
         */
        @SuppressWarnings("unchecked")
		public void subtract(){
                try{
                        Float second=getvalue(st.pop());
                        Float first=getvalue(st.pop());
                st.push(first-second);
                }catch(EmptyStackException ee){
                        System.out.println("There are not enough elements on the stack to perform the operation.");
                }
        }
        
        /**
         * multiply the given item to the top of the stack
         * precondition:have two operands can be popped up<br>
         * postcondition:execute the operation and put the result back to stack<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(log(n))<br>
         */
        @SuppressWarnings("unchecked")
		public void multiply(){
                try{
                        Float second=getvalue(st.pop());
                        Float first=getvalue(st.pop());
                st.push(first*second);
                }catch(EmptyStackException ee){
                        System.out.println("There are not enough elements on the stack to perform the operation.");
                }
        }
        
        /**
         * divide the given item to the top of the stack
         * precondition:have two operands can be popped up<br>
         * postcondition:execute the operation and put the result back to stack<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(log(n))<br>
         */
        @SuppressWarnings("unchecked")
		public void divide(){
                try{
                        Float second=getvalue(st.pop());
                        Float first=getvalue(st.pop());
                st.push(first/second);
                }catch(EmptyStackException ee){
                        System.out.println("There are not enough elements on the stack to perform the operation.");
                }
        }
        /**
         * Places the given item on the calculator's stack
         * @param item- The item to be added to the stack.
         * precondition:none<br>
         * postcondition:put the Float into the stack<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(1)<br>
         */
        @SuppressWarnings("unchecked")
		public void number(Float item){
                st.push(item);
        }
        
        /**
         * Emptys item from top of the stack
         * @return The top number on the RPN calculator's stack, or 0 if the stack is empty.
         * precondition:none<br>
         * postcondition:get the top item on the stack<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(log(n))<br>
         */
        public Object top(){
                try{
                return getvalue(st.peek());
                }catch(EmptyStackException ee){
                        return 0;
                }
        }
        
        /**
         * Pops the top items off of the RPN calculator's stack and put the data into the tree and push back the value to the stack.
         * precondition:have two operands can be popped up<br>
         * postcondition:assign the value to the key and put them to the tree<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(log(n))<br>
         */
        @SuppressWarnings("unchecked")
		public void assign(){
                try{
                Float value=getvalue(st.pop());
                String key=(String)st.pop();
                st.push(value);
                TD.put(key, value);
                }catch(EmptyStackException ee){
                        System.out.println("There are not enough elements on the stack to perform the operation.");
                }
        }
        /**
         * Places the given item on the calculator's stack
         * @param key
         * precondition:none<br>
         * postcondition:put the key into the stack<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(1)<br>
         */
        @SuppressWarnings("unchecked")
		public void variable(String key){
                st.push(key);
        }
        
        /**
         * Get the value of the object from the stack
         * @param operand an object in the expression
         * @return the value of the object 
         * precondition:none<br>
         * postcondition:get the value of the object<br>
         * bestcase:Theta(1)<br>
         * worstcase:Theta(log(n))<br>
         */
        public Float getvalue(Object operand){
                if(operand instanceof String)return TD.get((String)operand);
                else return (Float)operand;
        }
        
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub

    	}

}


