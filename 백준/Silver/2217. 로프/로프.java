import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        } // for

        Arrays.sort(arr);

        int w = 0;
        for (int i = 0; i < n; i++) {
            int weight = arr[i] * (n - i);
            if (weight > w) {
                w = weight;
            }
        }

        System.out.println(w);
    } // main
}
