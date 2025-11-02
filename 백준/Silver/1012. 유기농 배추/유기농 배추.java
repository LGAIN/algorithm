import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int count;

	public static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny);
			}
		}
	}

	public static boolean isValid(int i, int j) {
		return i >=0 && j >= 0 && i < map.length && j < map[0].length;
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			count = 0;
			map = new int[m][n];
			visited = new boolean[m][n];

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
			}

			for (int j = 0; j < m; j++) {
				for (int l = 0; l < n; l++) {
					if (map[j][l] == 1 && !visited[j][l]) {
						dfs(j, l);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}
}
