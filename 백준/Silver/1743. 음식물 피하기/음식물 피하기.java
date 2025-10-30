import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static int dfs(int[][] map, int x, int y) {
		visited[x][y] = true;
		int count = 1;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
				continue;
			}
			if (map[nx][ny] == 1 && !visited[nx][ny]) {
				count += dfs(map, nx, ny);
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = 1;
		}

		List<Integer> trashSize = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int count = dfs(map, i, j);
					trashSize.add(count);
				}
			}
		}

		Collections.sort(trashSize, (o1, o2) -> o2 - o1);
		System.out.println(trashSize.get(0));

	}
}
