import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		Deque<String> nameQ = new ArrayDeque<>();
		Deque<Integer> numQ = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			int x = num % 100;
			nameQ.add(name);
			numQ.add(x);
		}

		while (nameQ.size() > 1) {
			nameQ.pollFirst();
			int x = numQ.pollFirst();

			for (int i = 0; i < x - 1; i++) {
				nameQ.addLast(nameQ.pollFirst());
				numQ.addLast(numQ.pollFirst());
			}

			nameQ.pollFirst();
			numQ.pollFirst();
		}

		System.out.println(nameQ.poll());
	}
}
