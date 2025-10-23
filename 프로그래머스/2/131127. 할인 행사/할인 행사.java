import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap <String, Integer> wantMap = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        
        for (int i = 0; i < discount.length - 9; i++) {
             // 특정일 i에 회원가입 시 할인받는 제품 및 개수를 담은 HashMap 선언
            HashMap <String, Integer> discountMap = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                if (wantMap.containsKey(discount[i])) {
                    discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
                }
            }
            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }
        
        return answer;
    }
}