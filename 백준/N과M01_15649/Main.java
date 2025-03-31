package algorithm_gain.백준.N과M01_15649;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder("");

        for (int i = 1; i <= n; i++) {
            sb.append(i);
            for (int j = 0; j < m; j++) {
                sb.append(j+1).append(" ");
//                sb.append(j+);
            }
            sb.append("\n");
        } // for

    } // main
}
