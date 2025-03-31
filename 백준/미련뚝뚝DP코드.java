//package algorithm_gain.백준;
//
//public class 미련뚝뚝DP코드 {
//
//    public static void main(String[] args) {
//
//        int[][] map = new int[n+1][m+1];
//        int[][] dp = new int[n+1][m+1];
//        // n은 행 m은 열
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= m; j++) {
//                // index 범위 조건
//                if (j == 1) {
//                    dp[i+1][j] = Math.min(dp[i+1][j],
//                            dp[i-1][j+1][] + map[i][j] + map[i+1][j]);
//                    dp[i+1][j+1] =Math.min(dp[i+1][j+1],
//                            dp[i-1][j] + map[i][j] + map[i+1][j+1]);
//                } else if (j == m) {
//                    dp[i+1][j] = Math.min(dp[i+1][j],
//                            dp[i-1][j-1] + map[i][j] + map[i+1][j]);
//                    dp[i+1][j-1] = Math.min(dp[i+1][j-1],
//                            dp[i-1][j-1] + map[i][j] + map[i+1][j-1]);
//                } else {
//                    // 직진
//                    dp[i+1][j] = Math.min(dp[i+1][j],
//                            Math.min(dp[i-1][j-1], dp[i-1][j+1]) + map[i][j] + map[i+1][j]);
//                    // 왼쪽 대각선 이동
//                    dp[i+1][j-1] = Math.min(dp[i+1][j-1],
//                            Math.min(dp[i-1][j-1] , dp[i-1][j]) + map[i][j] + map[i+1][j-1]);
//                    // 오른쪽 대각선 이동
//                    dp[i+1][j+1] = Math.min(dp[i+1][j+1],
//                            Math.min(dp[i-1][j+1] , dp[i-1][j]) + map[i][j] + map[i+1][j+1]);
//                }
//            }
//        } // for
//    }
//}
