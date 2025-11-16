import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int n = elements.length;
        int[] arr = new int[n * 2];
        
        // 원형 배열을 2배로 확장
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = elements[i % n];
        }
        
        
        // prefix sum
        int[] prefix = new int [n * 2 + 1];
        for (int i = 1; i <= 2 * n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        
        Set<Integer> set = new HashSet<>();
        
        
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = prefix[start + len] - prefix[start];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}