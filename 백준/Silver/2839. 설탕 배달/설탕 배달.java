import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] w = new int[1+N];

        for (int i = 0; i <= N; i++) {
            w[i] = 10000;
        }

        w[3] = 1;
        if (N >= 5) {
            w[5] = 1;
        }

        for (int i = 3; i <= N ; i++) {
            if (w[i] != 10000) {
                if (i + 3 <= N) w[i + 3] = Math.min(w[i+3], w[i] + 1);
                if (i + 5 <= N) w[i + 5] = Math.min(w[i+5], w[i] + 1);
            }
        }
        if (N == 4 || N == 7) System.out.println(-1);
        else System.out.println(w[N]);

        br.close();
    } // main
}