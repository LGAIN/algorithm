import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] check = new boolean[n+1];

    public static void dfs(int start) {
        check[start] = true;
        sb.append(start + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[start][i] == 1 && !check[i])
                dfs(i);
        }
    } // dfs

    public static void bfs(int start) {
        // 대충 bfs 로직
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start + " ");
            for (int i = 1; i <= n ; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        } // while


    } // bfs

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        check = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        } // for

        dfs(v);
        sb.append("\n");
        check = new boolean[n+1];
        bfs(v);
        System.out.println(sb);

        br.close();
    } // main
}