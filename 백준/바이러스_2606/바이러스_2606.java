package algorithm_gain.백준.바이러스_2606;

import java.io.*;
import java.util.*;

public class 바이러스_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int computer;
    static boolean[] check;
    static int[][] map;


    public static void main(String[] args) throws IOException{
        computer = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());
        map = new int[computer+1][computer+1];
        check = new boolean[computer+1];

        for (int i = 1; i <= connection; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        } // for

        System.out.println(dfs(1, 0));

    } // main

    public static int dfs(int start, int cnt) {
        check[start] = true;
        for (int i = 1; i <= computer; i++) {
            if (map[start][i] == 1 && !check[i]) {
                cnt = dfs(i, cnt+1);
            }
        } // for
        return cnt;
    } // dfs

}