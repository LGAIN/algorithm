import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;
    static int n; static int m;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static Queue<int[]> queue;

    static void bfs(int i, int j) {
        queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int ci = cur[0];
            int cj = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if (isValid(ni, nj) && !visited[ni][nj] && map[ni][nj] == 1) {
                    queue.add(new int[] {ni, nj});
                    map[ni][nj] = map[ci][cj] + 1;
                    visited[ni][nj] = true;
                }
            }
        }

    } // bfs

    static boolean isValid (int i, int j) {
        if (i >= 0 && j >= 0 && i < n && j < m) return true;
        return false;
    }


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        } // 입력

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    } // main
}
