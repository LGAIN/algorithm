import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[] visited;
	static int n;
	static int m;
	static int count;

	public static void dfs(int i) {
		visited[i] = true;
		for (int j = 1; j <= n; j++) {
			if (map[i][j] == 1 && !visited[j]) {
				dfs(j);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}


		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
}
