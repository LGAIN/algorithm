import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		while (queue.size() != 1) {
			queue.pollFirst();
			queue.add(queue.pollFirst());
		}
		System.out.println(queue.poll());
	}
}
