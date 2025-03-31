package algorithm_gain.백준.집합_11723;

import java.io.*;
import java.util.*;

public class 집합_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                if (!s.contains(x)) s.add(x);
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                if (s.contains(x)) s.remove(s.indexOf(x));
            } else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                if (s.contains(x)) sb.append(1 + "\n");
                else sb.append(0 + "\n" );
            } else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                if (s.contains(x)) s.remove(s.indexOf(x));
                else s.add(x);
            } else if (command.equals("all")) {
                s = new ArrayList<>();
                for (int j = 1; j < 21; j++) {
                    s.add(j);
                }
            } else if (command.equals("empty")) {
                s = new ArrayList<>();
            }

        } // for

        System.out.println(sb);
    } // main
}
