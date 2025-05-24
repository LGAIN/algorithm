import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            int d_cnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] box = new int[100];
            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < d_cnt; i++) {
                Arrays.sort(box);
                if (box[99] - box[0] <= 1) break;
                box[0]++;
                box[99]--;
            }
            Arrays.sort(box);

            System.out.println("#" + tc + " " + (box[99] - box[0]));
        }

    }
}
