package algorithm_gain.백준.AC_5430;

import java.io.*;
import java.util.*;

public class AC_5430 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringBuilder sb = new StringBuilder();
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.replace("[", "").replace("]", "");
            String[] elements = input.split(",");

            Deque<Integer> deque = new LinkedList<>();
            boolean isReverse = false;
            boolean isError = false;

            for (String e : elements) {
                if (!e.isEmpty()) deque.add(Integer.parseInt(e));
            }

            for (char c : p.toCharArray()) {
                if (c == 'R') {
                    if (isReverse) isReverse = false;
                    else isReverse = true;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error");
                        isError = true;
                        break;
                    }
                    else {
                        if (!isReverse) deque.pollFirst();
                        else deque.pollLast();
                    }
                }
            }

            // print

            if (!isError) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(isReverse ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
                sb.append("]");
            }
            System.out.println(sb);
        } // for

    } // main
}
