import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) n * times[times.length - 1];
        long mid = (left + right) / 2;
                    
        while (left < right) {
            
            // temp = 처리 가능한 사람의 최대값
            long temp = 0;
            for (int t : times) {
                temp += mid / t;
            }
            
            if (n <= temp) {
                right = mid;
            } else if (n > temp) {
                left = mid + 1;
            }
            
            mid = (left + right) / 2;
            
        } // while
        
        return mid;
    } // solution
} // Solution