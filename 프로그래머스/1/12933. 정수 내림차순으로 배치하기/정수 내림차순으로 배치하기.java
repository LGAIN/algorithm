import java.util.*;

// 1. 정수 -> 문자열
// 2. 정렬
// 3. 문자열 -> 정수

class Solution {
    public long solution(long n) {    
        
        String[] numbers = String.valueOf(n).split("");
        for (String num : numbers) {
            System.out.print(num + " ");
        }
        
        Arrays.sort(numbers, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String num : numbers) {
            sb.append(num);
        }
    
        return Long.parseLong(sb.toString());
    }
}