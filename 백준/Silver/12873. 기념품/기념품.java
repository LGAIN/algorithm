import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			queue.addLast(i);
		}

		long step = 1;
		while (queue.size() != 1) {
			for (long i = 0; i < ((step * step * step) - 1) % queue.size(); i++) {
				queue.addLast(queue.pollFirst());
			}
			queue.pollFirst();
			step++;
		}
		System.out.println(queue.pollFirst());
	}
}
