import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n; static int m; static int k;
    static int[][] map;
    static boolean[][] visit;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static ArrayList<Integer> count = new ArrayList<>();

    static int dfs(int start_i, int start_j) {
        visit[start_i][start_j] = true;
        int cnt = 1;

        for (int d = 0; d < 4; d++) {
            int ni = start_i + di[d];
            int nj = start_j + dj[d];
            if (isValid(ni, nj) && map[ni][nj] == 0 && !visit[ni][nj]) {
                cnt += dfs(ni, nj);
            }
        }
        return cnt;
    } // bfs

    static boolean isValid(int i, int j) {
        if (i >= 0 && j >= 0 && i < m && j < n) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 높이
        n = Integer.parseInt(st.nextToken()); // 너비
        k = Integer.parseInt(st.nextToken());
        
        map = new int[m][n];
        visit = new boolean[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int down_a = Integer.parseInt(st.nextToken());
            int left_b = Integer.parseInt(st.nextToken());
            int up_a = Integer.parseInt(st.nextToken());
            int right_b = Integer.parseInt(st.nextToken());
            for (int b = left_b; b < right_b; b++) {
                for (int a = down_a ; a < up_a; a++) {
                    map[b][a] = 1;
                }
            }
        }
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        
        int group_cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] == 0) {
                    count.add(dfs(i, j));
                    group_cnt++;
                }
            }
        }
        Collections.sort(count);
        System.out.println(group_cnt);
        for (int i = 0; i < group_cnt; i++) {
            System.out.print(count.get(i) + " ");
        }
        br.close();
    } // main
}
