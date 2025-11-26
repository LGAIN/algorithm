import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][2];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		int[] dp = new int[n+2];

		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i-1]);
			int time = map[i][0];
			if (i + time <= n + 1) {
				dp[i + time] = Math.max(dp[i + time], dp[i] + map[i][1]);
			}
		}

		int max = 0;
		max = Math.max(dp[n], dp[n+1]);

		System.out.println(max);
	}
}
