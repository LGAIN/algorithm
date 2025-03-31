package algorithm_gain.백준.동물원_1309;

import java.io.*;

public class 동물원_1309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp_1 = new int[n+1]; // 왼쪽에 사자가 있을 때
        int[] dp_2 = new int[n+1]; // 오른쪽에 사자가 있을 때
        int[] dp_3 = new int[n+1]; // 왼쪽, 오른쪽 어디에서 사자가 없을 때

        dp_1[1] = 1;
        dp_2[1] = 1;
        dp_3[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp_1[i] = (dp_2[i-1] + dp_3[i-1]) % 9901;
            dp_2[i] = (dp_1[i-1] + dp_3[i-1]) % 9901;
            dp_3[i] = (dp_1[i-1] + dp_2[i-1] + dp_3[i-1]) % 9901;
        }
        int res = dp_1[n] + dp_2[n] + dp_3[n];
        System.out.println(res % 9901);
        br.close();
    }
}
