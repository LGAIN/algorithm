import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 현재 가격이 이전 가격보다 하락했다면
                int j = stack.pop();
                answer[j] = i - j;
            } // while
            stack.push(i);
        } // for
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }
        
        return answer;
    }
}