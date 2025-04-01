package algorithm_gain.백준.기적의매매법_20546;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] stock = new int[14];

    static int BNP (int money) {
        int cur_cash = money;
        int cnt = 0;
        int res = 0;

        for (int i = 0; i < 14; i++) {
            // 살 수 있을 만큼 구매
            cnt += cur_cash / stock[i];
            cur_cash %= stock[i];
        }

        res = cur_cash + stock[13] * cnt;
        return res;
    } //

    static int TIMING(int money) {
       int cur_cash = money;
       int up = -1;
       int down = -1;
       int cnt = 0;
       int res = 0;

       if (stock[0] > stock[1]) {
           up = 0;
           down = 1;
       }
       else if (stock[0] < stock[1]) {
           up = 1;
           down = 0;
       } else {
           up = 0;
           down = 0;
       }

        for (int i = 1; i < 14; i++) {

            if (stock[i] > stock[i-1]) {
                up++;
                down = 0;
                // 3일연속 상승시 전량 매도
                if (up >= 3) {
                    cur_cash += stock[i] * cnt;
                    cnt = 0;
                }
            } else up = 0;

            if (stock[i] < stock[i-1]) {
                down++;
                up = 0;
                // 3일 연속 하락시 전량 매수
                if (down >= 3) {
                    cnt += cur_cash/stock[i];
                    cur_cash %= stock[i];
                }
            } else down = 0;

            if (stock[i] == stock[i-1]) {
                up = 0;
                down = 0;
            }
        }
        res = cur_cash + stock[13] * cnt;
       return res;
    }//

    public static void main(String[] args) throws IOException{
        int cash = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) {
            stock[i] = Integer.parseInt(st.nextToken());
        } // 입력

        if (BNP(cash) > TIMING(cash)) System.out.println("BNP");
        else if (BNP(cash) < TIMING(cash)) System.out.println("TIMING");
        else System.out.println("SAMESAME");

    } // main
}
