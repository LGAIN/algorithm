import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, x;
	static ArrayList<int[]>[] list, reverseList;
	static final int INF = Integer.MAX_VALUE;

	public static int[] dijkstra(ArrayList<int[]>[] graph) {
		// 비용 기준 오름차순 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);

		pq.offer(new int[] {x, 0});
		dist[x] = 0;

		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int weight = cur[1];

			if (dist[node] < weight) continue;

			for (int[] next : graph[node]) {
				int nextNode = next[0];
				int nextWeight = next[1];

				if (dist[nextNode] > dist[node] + nextWeight) {
					dist[nextNode] = dist[node] + nextWeight;
					pq.offer(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());;

		list = new ArrayList[n+1];
		reverseList = new ArrayList[n+1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			list[u].add(new int[]{v, t});
			reverseList[v].add(new int[]{u, t});
		}

		int[] go = dijkstra(list);
		int[] back = dijkstra(reverseList);

		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, go[i] + back[i]);
		}
		System.out.println(max);
	}
}
