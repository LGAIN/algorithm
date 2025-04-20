import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        while (x > 0) {
            if (x % 2 == 1) count++;
            x /= 2;
        } // while
        System.out.println(count);
    } // main
}
