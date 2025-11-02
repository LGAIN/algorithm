import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		while (true) {
			Stack<Character> stack = new Stack<>();
			boolean isBalanced = true;

			String line = br.readLine();

			if (line.equals(".")) {
				break;
			}

			for (char c : line.toCharArray()) {
				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty() || stack.peek() != '(') {
						isBalanced = false;
						break;
					}
					stack.pop();
				} else if (c == ']') {
					if (stack.isEmpty() || stack.peek() != '[') {
						isBalanced = false;
						break;
					}
					stack.pop();
				}
			} // for
			if (!isBalanced || !stack.isEmpty()) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}
		} // while
	}
}
