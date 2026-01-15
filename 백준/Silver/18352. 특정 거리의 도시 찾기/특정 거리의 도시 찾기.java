import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int city = Integer.parseInt(st.nextToken());
		int street = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		List<Integer>[] graph = new ArrayList[city + 1];
        
        for (int i = 1; i <= city; i++) {
            graph[i] = new ArrayList<>();
        }
        
		for (int i = 0; i < street; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}

		int[] dist = new int[city + 1];
		Arrays.fill(dist, -1);

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(start);
		dist[start] = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();

			if (dist[curr] == target) continue;

			for (int next : graph[curr]) {
				if (dist[next] != -1) continue;
				dist[next] = dist[curr] + 1;
				queue.add(next);
			}
		}

		StringBuilder sb = new StringBuilder();
		boolean found = false;
		for (int i = 1; i <= city ; i++) {
			if (dist[i] == target) {
				sb.append(i).append('\n');
				found = true;
			}
		}

		if (!found) sb.append(-1).append('\n');
		System.out.println(sb);
	}
}
