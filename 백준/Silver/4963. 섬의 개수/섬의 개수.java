import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1, -1, 1, 1, -1};
	static int[] dy = {-1, 0, 1, 0, -1, 1, -1, 1};

	public static void dfs(int i, int j) {
		visited[i][j] = true;
		for (int k = 0; k < 8; k++) {
			int ni = i + dx[k];
			int nj = j + dy[k];
			if (isValid(ni, nj) && map[ni][nj] == 1 && !visited[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}

	public static boolean isValid(int i, int j) {
		return i >= 0 && i < h && j >= 0 && j < w;
	}

	public static void main(String[] args) throws IOException {

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) break;

			map = new int[h][w];
			visited = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);
		}
	}
}
