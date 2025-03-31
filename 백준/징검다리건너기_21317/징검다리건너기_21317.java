package algorithm_gain.백준.징검다리건너기_21317;

import java.io.*;
import java.util.*;

public class 징검다리건너기_21317 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] energy = new int[n+1][2];
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            energy[i][0] = Integer.parseInt(st.nextToken());
            energy[i][1] = Integer.parseInt(st.nextToken());
        } // for
        int k = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        Arrays.fill(dp, 5001);
        // dp 초기화
        dp[1] = 0;
        dp[2] = energy[1][0];
        dp[3] = Math.min(energy[2][1], energy[1][0] + energy[2][0]);
        // dp[4] = Math.min(dp[2] + energy[3][0], k);

        // dp 갱신
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + energy[i][0] , dp[i-2] + energy[i][1]);
        }
//
//        for (int i = 0; i < n; i++) {
//            System.out.print(energy[i][0] + " " + energy[i][1] + "\n");
//        }

        for (int i = 0; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }

    }// main
}