import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader (new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// step 1. DP 정의
		// step 2. 초기값 설정
		// step 3. DP 테이블 갱신

		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			System.out.println(wine[1]);
			return;
		} else if (n == 2) {
			System.out.println(wine[2] + wine[1]);
			return;
		} else if (n == 3) {
			dp[1] = wine[1];
			dp[2] = wine[2] + wine[1];
			System.out.println(Math.max(Math.max(wine[1], wine[2]) + wine[3], dp[2]));
			return;
		}

		dp[1] = wine[1];
		dp[2] = wine[2] + wine[1];
		dp[3] = Math.max(Math.max(wine[1], wine[2]) + wine[3], dp[2]);
		for (int i = 4; i <= n; i++) {
			dp[i] = Math.max(Math.max(dp[i-2], dp[i-3] + wine[i-1]) + wine[i], dp[i-1]);
		}

		System.out.println(dp[n]);


	}
}
