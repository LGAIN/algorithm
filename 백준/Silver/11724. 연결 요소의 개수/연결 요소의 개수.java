import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int n;

    static void dfs(int start) {
        visit[start] = true;

        for (int next : graph[start]) {
            if (!visit[next]) {
                dfs(next);
            }
        }

    } // dfs

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        visit = new boolean[n+1];
        int cnt = 0;
        // v 입력
        for (int v = 1; v <= n; v++) {
            graph[v] = new ArrayList<>();
        }
        // e 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    } // main
}
