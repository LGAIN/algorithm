import java.util.*;

class Solution {
    int answer = Integer.MAX_VALUE;
    boolean[] visited;
    public void dfs(String curr, String target, String[] words, int count) {
        
        if (curr.equals(target)) {
            answer = Math.min(count, answer);
            return ;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canChange(curr, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                visited[i] = false;
            }
        } // for
        
        
        return ;
    } // dfs
    
    public boolean canChange(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
            if (diff > 2) return false;
        }
        
        if (diff == 1) return true;
        
        return false;
    } // canChange
    
    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    } // solution
} // Solution