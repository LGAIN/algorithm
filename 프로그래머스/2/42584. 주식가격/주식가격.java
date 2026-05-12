// import java.util.*;

// class Solution {
//     public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];
//         Stack<Integer> stack = new Stack<>();
        
//         for (int i = 0; i < prices.length; i++) {
//             while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
//                 int idx = stack.pop();
//                 answer[idx] = i - idx;
//             } // while
            
//             stack.push(i);
                
//         } // for
        
//         while (!stack.isEmpty()) {
//             int idx = stack.pop();
//             answer[idx] = prices.length - idx - 1;
//         } // while
        
//         return answer;
//     } // solution
// } // Solution
















// class Solution {
//     public int[] solution(int[] prices) {

//         int[] answer = new int[prices.length];

//         for (int j = 0; j < prices.length; j++) {

//             int count = 0;

//             for (int i = j + 1; i < prices.length; i++) {

//                 count++;

//                 if (prices[j] > prices[i]) {
//                     break;
//                 }
//             }

//             answer[j] = count;
//         }

//         return answer;
//     }
// }

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
        int a = 1;
        return answer;
    }
}