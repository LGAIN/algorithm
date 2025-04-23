import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> arr = new HashMap<>();
    static int[] origin;
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        origin = new int[n];
        sorted = new int[n];
        for (int i = 0; i < n; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int v : sorted) {
            if (!arr.containsKey(v)) {
                arr.put(v, rank);
                rank++;
            }
        }

        for (int key : origin) {
            int ranking = arr.get(key);
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    } // main
}
