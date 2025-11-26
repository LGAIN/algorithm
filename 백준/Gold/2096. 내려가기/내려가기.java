import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] max_dp = new int[n][3];
		int[][] min_dp = new int[n][3];

		for (int i = 0; i < 3; i++) {
			max_dp[0][i] = min_dp[0][i] = map[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 1) {
					max_dp[i][j] = Math.max(max_dp[i-1][j], Math.max(max_dp[i-1][j-1], max_dp[i-1][j+1])) + map[i][j];
					min_dp[i][j] = Math.min(min_dp[i-1][j], Math.min(min_dp[i-1][j-1], min_dp[i-1][j+1])) + map[i][j];
				} else if (j == 0) {
					max_dp[i][j] = Math.max(max_dp[i-1][j], max_dp[i-1][j+1]) + map[i][j];
					min_dp[i][j] = Math.min(min_dp[i-1][j], min_dp[i-1][j+1]) + map[i][j];
				} else if (j == 2) {
					max_dp[i][j] = Math.max(max_dp[i-1][j], max_dp[i-1][j-1]) + map[i][j];
					min_dp[i][j] = Math.min(min_dp[i-1][j], min_dp[i-1][j-1]) + map[i][j];
				}
			}
		}

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (max < max_dp[n-1][i]) max = max_dp[n-1][i];
			if (min > min_dp[n-1][i]) min = min_dp[n-1][i];
		}
		StringBuilder sb = new StringBuilder("");
		sb.append(max).append(" ").append(min);
		System.out.println(sb);
	}
}
