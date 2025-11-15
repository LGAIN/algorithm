import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		List<int[]>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[a].add(new int[]{b, cost});
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int res = dijkstra(start, end, n, graph);

		System.out.println(res);
	}

	private static int dijkstra(int start, int end, int n, List<int[]>[] graph) {
		final int INF = Integer.MAX_VALUE;

		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		pq.add(new int[]{start, 0});

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int cost = cur[1];

			if (dist[node] < cost) continue;

			for (int[] next : graph[node]) {
				int nextNode = next[0];
				int nextCost = cost + next[1];
				if (dist[nextNode] > nextCost) {
					dist[nextNode] = nextCost;
					pq.add(new int[]{nextNode, nextCost});
				}
			}
		}
		return dist[end];
	}
}
