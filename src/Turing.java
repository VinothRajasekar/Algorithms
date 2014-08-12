import java.io.*;
import java.util.Date;

public class Turing{

	@SuppressWarnings("unused")
	private int states;
	private TuringTransition[][] instructions;
	private int q;
	static char[] tape;
	static int n;

	public Turing(int s) {
		states = s;
		instructions = new TuringTransition[s][3];
		q = 0;
	}

	public void addTransition(int curstates, char symbol, TuringTransition todo) {
		switch (symbol) {
		case '0':
			instructions[curstates][0] = new TuringTransition(todo.getSymbol(),
					todo.getAction(), todo.getStates());
			break;
		case '1':
			instructions[curstates][1] = new TuringTransition(todo.getSymbol(),
					todo.getAction(), todo.getStates());
			break;
		case 'B':
			instructions[curstates][2] = new TuringTransition(todo.getSymbol(),
					todo.getAction(), todo.getStates());
			break;
		}
	}

	public static void initializeTape() {
		for (int i = 0; i < n; i++) {
			tape[i] = 'B';
		}
	}

	public int getNum(char s) {
		if (s == 'B')
			return 2;
		else
			return Integer.parseInt(Character.toString(s));
	}

	public static boolean checkRoomOnTape() {
		for (int i = 0; i < n; i++) {
			if (tape[i] != '1')
				return true;
		}
		return false;
	}

	public static void displayTape() {
		String result = "";
		for (int i = n - 1; i >= 0; i--) {
			if (tape[i] != 'B')
				result = tape[i] + result;
			else
				break;
		}
		System.out.println(result);
	}

	public void execute() {
		q = 0;
		int pointer = n - 1;
		while (q != 2) {
			TuringTransition go = instructions[q][getNum(tape[pointer])];
			q = go.getStates();
			tape[pointer] = go.getSymbol();
			if (go.getAction() == 0)
				pointer--;
			if (go.getAction() == 1)
				pointer++;
		}
	}

	/* 
	 * For the checkRoomOnTape method the wost case is Big theta(n);
	 * For the display tape both the best and worst case are theta(n);
	 * For the machine.execute method Big theta (n*2^n)
	 * From above the Big Theta Time Complexity will be - Big theta (n*2^n). 
	 */
	
	public static void main(String args[]) throws IOException {

		System.out.println("How much tape do you have?");
		BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
		String line = is.readLine();
		n = Integer.parseInt(line);

		tape = new char[n];
		
		Turing machine = new Turing(3);


		machine.addTransition(0, 'B', new TuringTransition('0', TuringTransition.LEFT, 2));
		machine.addTransition(0, '0', new TuringTransition('1', TuringTransition.LEFT, 2));
		machine.addTransition(0, '1', new TuringTransition('0', TuringTransition.LEFT, 1));


		machine.addTransition(1, '1', new TuringTransition('0', TuringTransition.LEFT, 1));
		machine.addTransition(1, 'B', new TuringTransition('1', TuringTransition.LEFT, 2));
		machine.addTransition(1, '0', new TuringTransition('1', TuringTransition.LEFT, 2));

		initializeTape();

		long starttime = System.nanoTime();
		long starttime1 = new Date().getTime();

		while (checkRoomOnTape()) {
			machine.execute(); 
			displayTape();
		}

		long stoptime1 = new Date().getTime();
		long stoptime = System.nanoTime();
		long time = (stoptime - starttime);
		long timea = (stoptime1 - starttime1);
		int time1 = (int) (time / 1000000000);
		System.out.println("Program complete in " + time + " nano seconds");
		System.out.println("Program complete in roughly " + time1 + " seconds");

	}

}