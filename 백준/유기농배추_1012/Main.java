package algorithm_gain.백준.유기농배추_1012;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<int[]>();
    static boolean[][] check;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs(int a, int b){
        q.add(new int[] {a, b});
        check[a][b] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (!check[nx][ny] && map[nx][ny] == 1) {
                    check[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        } // while

    } // bfs

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            map = new int[n+1][m+1];
            check = new boolean[n+1][m+1];

            // 배추 위치 초기화
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int group_cnt = 0;
            // 지렁이 수 찾기
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (map[j][l] == 1 && !check[j][l]) {
                        bfs(j, l);
                        group_cnt++;
                    }
                }
            } // for

            System.out.println(group_cnt);
        }

        br.close();
    }
}
