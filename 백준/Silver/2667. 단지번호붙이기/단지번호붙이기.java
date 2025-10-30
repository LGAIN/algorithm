import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[][] visited;
	static int[] di = {0, 1, 0, -1};
	static int[] dj = {1, 0, -1, 0};

	static int dfs(int[][]map, int i, int j) {
		int cnt = 1;
		visited[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni < 0 || nj < 0 || ni >= map.length || nj >= map[0].length) {
				continue;
			}
			if (!visited[ni][nj] && map[ni][nj] == 1) {
				cnt += dfs(map, ni, nj);

			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		} // map 입력

		List<Integer> houseCount = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int count = dfs(map, i, j);
					houseCount.add(count);
				}
			}
		}

		Collections.sort(houseCount);
		System.out.println(houseCount.size());
		for (int c :  houseCount) {
			System.out.println(c);
		}
	}
}
