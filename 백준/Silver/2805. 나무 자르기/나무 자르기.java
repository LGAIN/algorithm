import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] trees;
    static int h; static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        } // for

        Arrays.sort(trees);

        int left = 1; // 가장 작은 입력의 높이
        int right = trees[n-1]; // 가장 큰 나무의 높이
        int mid = (left + right) / 2; // 현재 절단기에 설정된 높이
        long sum = 0;

        while (left <= right) {
            for (int i = 0; i < n; i++) {
                if (trees[i] - mid > 0) sum += trees[i] - mid;
            }
            if (sum < h) {
                right = mid - 1;
                mid = (left + right) / 2;
                sum = 0;
            } else if (sum > h) {
                left = mid + 1;
                mid = (left + right) / 2;
                sum = 0;
            } else {
                mid = (left + right) / 2;
                break;
            }

        } // while

        System.out.println(mid);
    } // main
}
