package algorithm_gain.백준.숫자1로만들기_1463;

import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int[] dp = new int[x+1];
        dp[x] = 0;
        for (int i = 1; i < x; i++) {
            dp[i] = 100000;  // 적당히 큰 수
        }

        for (int i = x; i > 0; i--) {
            if (i % 2 == 0) dp[i/2] = Math.min(dp[i] + 1, dp[i/2]);
            if (i % 3 == 0) dp[i/3] = Math.min(dp[i] + 1, dp[i/3]);
            dp[i-1] = Math.min(dp[i] + 1, dp[i-1]);
        } // for
        System.out.println(dp[1]);
    } // main
}
