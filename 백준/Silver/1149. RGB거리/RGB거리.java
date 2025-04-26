import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<int[]> rgb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            rgb.add(new int[] {r, g, b});
        }

        int previous = 0;
        int[][] sum = new int[n][3];

        for (int c = 0; c < 3; c++) {
            sum[0][c] = rgb.get(0)[c];
        } // 초기화

        for (int i = 1; i < n; i++) {
            sum[i][0] = Math.min(sum[i-1][1], sum[i-1][2]) + rgb.get(i)[0]; // 빨강
            sum[i][1] = Math.min(sum[i-1][0], sum[i-1][2]) + rgb.get(i)[1]; // 초록
            sum[i][2] = Math.min(sum[i-1][0], sum[i-1][1]) + rgb.get(i)[2]; // 파랑
        }

        System.out.println(Math.min(sum[n-1][0], Math.min(sum[n-1][1], sum[n-1][2])));
    } // main
}
