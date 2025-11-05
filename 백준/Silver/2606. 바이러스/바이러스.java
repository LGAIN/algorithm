import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[] visited;
	static int count;

	public static void dfs(int i) {
		visited[i] = true;
		for (int k = 1; k < map.length; k++) {
			if (map[i][k] == 1 && !visited[k]) {
				count++;
				dfs(k);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int v = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}

		count = 0;
		dfs(1);

		System.out.println(count);
	}
}
