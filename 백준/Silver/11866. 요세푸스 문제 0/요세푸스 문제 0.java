import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Deque <Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}
		System.out.print("<");
		while (q.size() > 1) {
			for (int i = 0; i < m-1; i++) {
				q.add(q.poll());
			}
			System.out.print(q.poll() + ", ");
		}
		System.out.println(q.poll() + ">");
	}
}
