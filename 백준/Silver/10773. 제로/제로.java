import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			int command = Integer.parseInt(br.readLine());
			if (command == 0) {
				sum -= stack.pop();
			} else {
				stack.push(command);
				sum += command;
			}
		}
		System.out.println(sum);
	}
}
