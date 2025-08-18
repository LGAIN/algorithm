import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        if (s.length() == 0) {
            System.out.println(0);
            return;
        }

        int zeroRun = 0;
        int oneRun = 0;

        char prev = s.charAt(0);
        if (prev == '0') {
            zeroRun++;
        } else {
            oneRun++;
        }

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (curr != prev) {
                if (curr == '0') {
                    zeroRun++;
                } else {
                    oneRun++;
                }
                prev = curr;
            }
        }

        int answer = Math.min(zeroRun, oneRun);
        System.out.println(answer);

    } // main
}
