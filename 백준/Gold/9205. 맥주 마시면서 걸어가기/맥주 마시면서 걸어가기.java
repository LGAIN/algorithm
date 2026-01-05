import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int dist (int[] a , int[] b) {
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			List<int[]> spots = new ArrayList<>();
			for (int j = 0; j < n + 2; j++) {
				st = new StringTokenizer(br.readLine());
				spots.add(new int[] {
					Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())
				});
			}

			boolean[] visited = new boolean[n+2];
			ArrayDeque<Integer> q = new ArrayDeque<>();
			q.add(0);
			visited[0] = true;

			boolean ok = false;

			while (!q.isEmpty()) {
				int cur = q.poll();
				if (cur == n+1) {
					ok = true;
					break;
				}
				for (int j = 0; j < n+2; j++) {
					if (!visited[j] && dist(spots.get(cur), spots.get(j)) <= 1000 ) {
						visited[j] = true;
						q.add(j);
					}
				}
			}
			System.out.println(ok ? "happy" : "sad");
		}
	}
}
