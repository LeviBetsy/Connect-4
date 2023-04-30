import java.util.ArrayList;

public class MyStack {
	private ArrayList<char[][]> stackArrayList;
	private int undos;

	public MyStack(int s, int u) {
		stackArrayList = new ArrayList<char[][]>(s);
		undos = u;
	}

	public void push(char[][] j) {
		// char[][] newj = new char[j.length][j[0].length];
		char[][] newj = new char[7][6];
		// newj = j.clone();

		stackArrayList.add(newj);
		if (stackArrayList.size() > undos) {
			stackArrayList.remove(0);
		}
	}

	public char[][] pop() {
		return stackArrayList.remove(stackArrayList.size() - 1);
	}

	public char[][] peek() {
		return stackArrayList.get(stackArrayList.size() - 1);
	}

	public boolean isEmpty() {
		return stackArrayList.isEmpty();
	}

	public void print() {
		for (char[][] x : stackArrayList) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
