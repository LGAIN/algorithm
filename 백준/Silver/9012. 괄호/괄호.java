import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			boolean isBalanced = true;
			Stack<Character> stack = new Stack<>();
			for (Character c : line.toCharArray()) {
				if (c == '(' ) {
					stack.push(c);
				} else if (c == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						isBalanced = false;
						break;
					}
				}
			}
			if (stack.isEmpty() && isBalanced) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
