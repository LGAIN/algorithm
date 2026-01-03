import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> time_stack = new Stack<>();
		Stack<Integer> score_stack = new Stack<>();
		int time = 0;
		int score = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int task = Integer.parseInt(st.nextToken());
			if (task == 1) {
				int s = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				if (t == 1) {
					score += s;
				} else {
					time_stack.push(t-1);
					score_stack.push(s);
				}
				time++;
			} else if (!time_stack.isEmpty() && !score_stack.isEmpty()) {
				time++;
				int next = time_stack.pop() - 1;
				if (next != 0) time_stack.push(next);
				if (next == 0) score += score_stack.pop();
			}

		}
		System.out.println(score);
	}
}
