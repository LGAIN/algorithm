import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static ArrayList<Integer> budget = new ArrayList<>();

    static int calc(int h) {
        int total = 0;
        for (int i = 0; i < budget.size(); i++) {
            total += Math.min(budget.get(i), h);
        }
        return total;
    } // calc

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int req_budget = Integer.parseInt(st.nextToken());
            budget.add(req_budget);
            sum += req_budget;
        }
        int budget_sum = Integer.parseInt(br.readLine());

        int res = 0;
        int low = 1;
        int high = Collections.max(budget);

        // 예산 요청의 합이 총 예산 이하인 경우 가장 큰 예산 요청 값을 출력하고 종료
        if (sum <= budget_sum) {
            System.out.println(high);
            return;
        }

        // 이분탐색
        while (low < high - 1) {
            int mid = (low + high) / 2;
            if (calc(mid) > budget_sum) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(low);

    } // main
}
