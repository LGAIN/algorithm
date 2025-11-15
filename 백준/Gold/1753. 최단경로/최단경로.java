import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int v, e, start;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine());

		List<int[]>[] graph = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] {b, cost});
		}

		int[] dist = dijkstra(start,  v, graph);

		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}

	public static int[] dijkstra(int start, int v, List<int[]>[] graph) {
		final int INF = Integer.MAX_VALUE;

		int[] dist = new int [v+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] {start, 0});

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currCost = curr[1];

			if (dist[currNode] < currCost) continue;

			for (int[] next : graph[currNode]) {
				int nextNode = next[0];
				int nextCost = currCost + next[1];

				if (dist[nextNode] > nextCost) {
					dist[nextNode] = nextCost;
					pq.add(new int[] {nextNode, nextCost});
				}
			}
		}

		return dist;
	}
}
