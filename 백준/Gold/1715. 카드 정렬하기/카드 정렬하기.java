import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int count = 0;

		while (pq.size() > 1) {
			int tmp1 = pq.poll();
			int tmp2 = pq.poll();
			count += tmp1 + tmp2;
			pq.add(tmp1 + tmp2);
		}

		System.out.println(count);
	}
}
