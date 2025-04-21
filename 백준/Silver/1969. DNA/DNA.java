import java.io.*;
import java.util.*;

/* 백준 1969 DNA Sliver IV
 * 1. DNA 물질을 array에 입력받는다.
 * 2. 입력 받은 물질을 첫번째 열부터 끝 열까지 비교하며,
 *    가장 많이 나온 알파벳을 append한다
 * */

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        // 완전 탐색하며 비교
        int distance = 0;
        for (int j = 0; j < m; j++) {
            int[] count = new int[4];
            for (int i = 0; i < n; i++) {
                if (arr[i][j].equals("A")) count[0]++;
                else if (arr[i][j].equals("T")) count[1]++;
                else if (arr[i][j].equals("G")) count[2]++;
                else if (arr[i][j].equals("C")) count[3]++;
            }
            char[] base = {'A', 'T', 'G', 'C'};
            int max = 0;
            int max_idx = 0;
            for (int k = 0; k < 4; k++) {
                if (count[k] > max || (count[k] == max && base[k] < base[max_idx])) {
                    max = count[k];
                    max_idx = k;
                }
            }

            sb.append(base[max_idx]);
            for (int i = 0; i < n; i++) {
                if (base[max_idx] != arr[i][j].charAt(0)) distance++;
            }
        }

        System.out.println(sb);
        System.out.println(distance);
    } // main
}
