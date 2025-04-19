import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int m; static int n; static int maxDay = 0;
    static int[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList();

    static void bfs () {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int day = cur[2]; // 날짜

            for (int d = 0; d < 4; d++) {
                int nx = cx + di[d];
                int ny = cy + dj[d];
                if (isValid(nx, ny) &&  map[nx][ny] == 0){
                   map[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny, day + 1});
                }
            }
            maxDay = Math.max(maxDay, day);
        }
    }

    static boolean isValid (int i, int j) {
        if (i >= 0 && j >= 0 && i < n && j < m) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.offer(new int[] {i, j, 0});
                }
            }
        } // map 입력


        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxDay);

    } // main
}
