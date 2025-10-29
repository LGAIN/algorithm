import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1. int 배열을 String 배열로 전환
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬
        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (result[0].equals("0")) {
            return "0";
        }
        
        // 이어 붙이기
        StringBuilder answer = new StringBuilder();
        for (String num : result) {
            answer.append(num);
        }
        
        return answer.toString();
    }
}