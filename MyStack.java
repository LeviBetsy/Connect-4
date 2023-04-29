import java.util.ArrayList;

public class MyStack {
	private ArrayList<Board> stackArrayList;
	private int undos;

	public MyStack(int s, int u) {
		stackArrayList = new ArrayList<Board>(s);
		undos = u;
	}

	public void push(Board j) {
		stackArrayList.add(j);
		if (stackArrayList.size() > undos) {
			stackArrayList.remove(0);
		}
	}

	public Board pop() {
		return stackArrayList.remove(stackArrayList.size() - 1);
	}

	public Board peek() {
		return stackArrayList.get(stackArrayList.size() - 1);
	}

	public boolean isEmpty() {
		return stackArrayList.isEmpty();
	}

	public void print() {
		for (Board x : stackArrayList) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
}
