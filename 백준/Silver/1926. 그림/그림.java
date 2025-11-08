import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static int maxLength = 0;
	static int length = 1;

	public static int dfs(int x, int y) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny);
				length++;
			}
		}
		return length;
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && x < map.length && y >= 0 &&  y < map[0].length;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int dfsCount = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					dfsCount++;
					if (length > maxLength) {
						maxLength = length;
					}
					length = 1;
				}
			}
		}

		System.out.println(dfsCount);
		System.out.println(maxLength);


	}
}
