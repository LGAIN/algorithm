import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<>();
		int last = -1;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				last = Integer.parseInt(st.nextToken());
				queue.add(last);
			} else if (command.equals("pop")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.poll());
				}
			} else if (command.equals("size")) {
				System.out.println(queue.size());
			} else if (command.equals("empty")) {
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (command.equals("front")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.peek());
				}
			} else if (command.equals("back")) {
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(last);
				}
			}
		}
	}
}
