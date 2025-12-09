import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n+1];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i <= k; i++) {
			for (int j = 0; j <= n ; j++) {
				if (i + coins[j] <= k)
					dp[i + coins[j]] = Math.min(dp[i] + 1, dp[i + coins[j]]);
			}
		}

		System.out.println(dp[k]);
	}
}
