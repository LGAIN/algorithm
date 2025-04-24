import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] map;
    static char[][] new_map;
    static int r; static int c;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    static void global_warming(int i, int j) {
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (isRange(ni, nj) && map[ni][nj] == '.' ) count++;
            if (!isRange(ni,nj)) count++;
        }
        if (count >= 3) new_map[i][j] = '.';
    }

    static boolean isRange(int i, int j) {
        if (i >= 0 && j >= 0 && i < r && j < c) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        new_map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = new_map[i][j] = line.charAt(j);
            }
        } // 입력

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                global_warming(i, j);
            }
        }

        int start_i = r-1;
        int start_j = c-1;
        int end_i = 0;
        int end_j = 0;


        // 지도 사이즈 줄이기
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (new_map[i][j] == 'X') {
                    start_i = Math.min(start_i, i);
                    end_i = Math.max(end_i, i);
                    start_j = Math.min(start_j, j);
                    end_j = Math.max(end_j, j);
                }
            }
        }

        // 출력
        for (int i = start_i; i <= end_i; i++) {
            for (int j = start_j; j <=end_j; j++) {
                System.out.print(new_map[i][j]);
            }
            System.out.println();
        }
    }
}
