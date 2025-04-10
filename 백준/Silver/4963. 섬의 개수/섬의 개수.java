import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w; static int h;
    static int[][] map;
    static boolean[][] visit;
    static int[] di = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dj = {0, 0, -1, 1, 1, -1, -1, 1};

    static void dfs (int start_i, int start_j) {
        visit[start_i][start_j] = true;

        for (int d = 0; d < 8; d++) {
            int ni = start_i + di[d];
            int nj = start_j + dj[d];
            if (isValid(ni, nj) && !visit[ni][nj] && map[ni][nj] == 1) {
                dfs(ni, nj);
            }
        }
    } // dfs

    static boolean isValid (int i, int j) {
        if (i >= 0 && j >= 0 && i < h && j < w) return true;
        return false;
    } // isValid

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) break;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // map 입력

            visit = new boolean[h][w];
            int cnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        } // while


    } // main
}
