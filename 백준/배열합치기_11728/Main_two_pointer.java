package algorithm_gain.백준.배열합치기_11728;

import java.io.*;
import java.util.*;

public class Main_two_pointer {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr_a = new int[n];
        int[] arr_b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr_a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr_b[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;

        StringBuilder sb = new StringBuilder();

        while (i < n && j < m) {
            if (arr_a[i] <= arr_b[j]) {
                sb.append(arr_a[i]).append(" ");
                i++;
            }
            else {
                sb.append(arr_b[j]).append(" ");
                j++;
            }
        }

        while (i < n) {
            sb.append(arr_a[i]).append(" ");
            i++;
        }
        while (j < m) {
            sb.append(arr_b[j]).append(" ");
            j++;
        }

        System.out.println(sb);
        br.close();
    } // main
}
