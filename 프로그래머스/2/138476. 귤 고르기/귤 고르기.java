import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> cntMap = new HashMap<>();
        
        // 귤 크기 별 개수 세기
        for (int size : tangerine) {
            cntMap.put(size, cntMap.getOrDefault(size, 0) + 1);
        }
        
        // 개수만 뽑아서 내림차순 정렬
        List<Integer> counts = new ArrayList<>(cntMap.values());
        counts.sort(Collections.reverseOrder());
        
        // 큰 빈도 부터 k 개 채우기
        int sum = 0;
        int kind = 0;
        
        for (int c : counts) {
            sum += c;
            kind++;
            if (sum >= k) break;
        }
        
        return kind;
    }
}