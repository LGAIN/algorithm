package algorithm_gain.백준.배열합치기_11728;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr_res = new int[n+m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr_res[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = n; i < n + m; i++) {
            arr_res[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr_res);

        sb = new StringBuilder("");
        for (int i = 0; i < n+m; i++) {
            sb.append(arr_res[i]).append(" ");
        }

        System.out.println(sb);
    } // main
}
