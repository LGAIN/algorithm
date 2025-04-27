import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr ;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
                else if (j == i) dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[n-1][j]);
        }
        System.out.println(max);
    } // main
}
