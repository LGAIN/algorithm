import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			LinkedList<int[]> docs = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine());
			for (int index = 0; index < n; index++) {
				int priority = Integer.parseInt(st.nextToken());
				pq.add(priority);
				docs.add(new int[] {priority, index});
			}

			int count = 0;
			while (!docs.isEmpty()) {
				int[] doc = docs.pollFirst();
				int priority = doc[0];
				int index = doc[1];
				if (priority == pq.peek()) {
					count++;
					pq.poll();
					if (index == m) {
						System.out.println(count);
						break;
					}
				} else {
					docs.addLast(doc);
				}
			}
		}


	}
}
