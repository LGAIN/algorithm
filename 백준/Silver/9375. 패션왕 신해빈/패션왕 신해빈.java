import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> arr = new HashMap<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String group = st.nextToken();
                arr.put(group, arr.getOrDefault(group, 0)+1);
            }

            int ans = 1;
            for (int count : arr.values()) {
                ans *= (count + 1);
            }
            System.out.println(ans-1);
        }

    } // main
}
