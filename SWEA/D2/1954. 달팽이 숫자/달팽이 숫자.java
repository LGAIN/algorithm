import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n;

    static boolean isValid(int x, int y) {
        if (x >= 0 && y >= 0 && x < n && y < n) {
            return true;
        }
        return false;
    } // isValid


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            n = Integer.parseInt(br.readLine());

            int[][] snail = new int[n][n];
            int num = 1;
            int dir = 0;
            int x = 0; int y = 0;
            // 달팽이 수 채우기
            for (int i = 0; i < n*n; i++) {
                snail[x][y] = num++;

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (!isValid(nx, ny) || snail[nx][ny] != 0) {
                    dir = (dir+1) % 4;
                    nx = x + dx[dir];
                    ny = y + dy[dir];
                }

                x = nx;
                y = ny;
                
            }

            System.out.println("#" + (test_case+1));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }


        }
    }
}