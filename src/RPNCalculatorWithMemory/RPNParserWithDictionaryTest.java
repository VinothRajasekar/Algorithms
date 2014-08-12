package RPNCalculatorWithMemory;

import static org.junit.Assert.*;

import org.junit.Test;

import RPNCalculator.Stack;

public class RPNParserWithDictionaryTest {

    Stack st =new Stack();
    
    
    public void stpush(){
            st.push(3f);
            assertEquals("push method fails",3f,st.peek(),0);
    }
    private void assertEquals(String string, float f, Object peek, int i) {
		// TODO Auto-generated method stub
		
	}

    public void stempty(){
            assertTrue("isempty method fails",st.isEmpty());
    }
    
}
