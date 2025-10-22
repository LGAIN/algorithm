import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        System.out.print("<");
        while (deque.size() > 1) {
            for (int i = 0; i < K-1; i++) {
                deque.addLast(deque.pollFirst());
            }
            System.out.print(deque.pollFirst() + ", ");
        }
        System.out.print(deque.pollFirst());
        System.out.println(">");
    }
}
