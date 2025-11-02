import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int num = 1;
		Stack<Integer> stack = new Stack<>();

		boolean isPossible = true;
		for (int i = 0; i < n; i++) {
			int target = Integer.parseInt(br.readLine());

			while (num <= target) {
				stack.push(num++);
				sb.append("+\n");
			}

			if (stack.peek() == target) {
				stack.pop();
				sb.append("-\n");
			} else {
				isPossible = false;
				break;
			}
		}

		System.out.println(isPossible ? sb : "NO");

	}
}
