import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[] visited;

    static int n; static int a; static int b;
	static int answer = -1;

    public static void dfs(int i, int depth) {
		visited[i] = true;
		if (i == b) {
			answer = depth;
			return;
		}
		for (int k = 1; k <= n; k++) {
			if (isValid(k) && !visited[k] && map[i][k] == 1) {
				dfs(k, depth + 1);
			}
		}
	}

	public static boolean isValid(int i) {
		return i > 0 && i <= n;
	}

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
        }

		dfs(a, 0);
		System.out.println(answer);
    }
}
