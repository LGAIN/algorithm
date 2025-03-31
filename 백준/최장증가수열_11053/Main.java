package algorithm_gain.백준.최장증가수열_11053;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                int left = 0;
                int right = lis.size();

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (lis.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right =  mid;
                    }
                } // while
                lis.set(left, num);
            } // if-else

        }

        System.out.println(lis.size());
    } // main
}
