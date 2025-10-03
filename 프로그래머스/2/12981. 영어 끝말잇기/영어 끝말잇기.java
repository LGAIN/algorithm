import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        
        Set<String> used = new HashSet<>();
        
        used.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            
            String prev = words[i-1];
            String now = words[i];
            
            if (prev.charAt(prev.length() - 1) != now.charAt(0)) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            } 
            
            int before = used.size();
            used.add(now);
            if (used.size() == before) {
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            
            used.add(words[i]);
            
        }

        return new int[] {0, 0};
    }
}