import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static int n; static int m;
    static int[] selected;

    static void dfs(int depth, int start) {
        if (depth == m) {
            for (int num : selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            dfs(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();
        selected = new int[m];
        dfs(0, 1);
        System.out.print(sb);

    } // main

}
