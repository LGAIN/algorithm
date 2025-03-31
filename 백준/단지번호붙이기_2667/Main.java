package algorithm_gain.백준.단지번호붙이기_2667;
import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] visit;
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer> house_cnt = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        } // for
        visit = new int[n][n];
        int group_cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && visit[i][j] != 1) {
                    BFS(i, j);
                    group_cnt++;
                }
            }
        } // for

        System.out.println(group_cnt);
        Collections.sort(house_cnt);
        for (int i = 0; i < group_cnt; i++) {
            System.out.println(house_cnt.get(i));
        }

    } // main


    static void BFS(int a, int b){
        visit[a][b] = 1; // 방문 처리
        queue.add(new int[] {a, b});
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (visit[nx][ny] != 1 && map[nx][ny] == 1) {
                    visit[nx][ny] = 1;
                    queue.add(new int[] {nx, ny});
                    cnt++;
                }
            }
        }// while
        house_cnt.add(cnt);
    } // BFS

}