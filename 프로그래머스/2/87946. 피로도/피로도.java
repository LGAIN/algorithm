    import java.util.*;

class Solution {
    
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        // k = 입력되는 피로도
        // dungeons[][] ["최소 필요 피로도", "소모 피로도"] 
        // temp_k = 계산 중 사용되는 피로도
        int temp_k = k;
        int count = 0;
        visited = new boolean[dungeons.length];
        dfs(temp_k, dungeons, 0);
        return answer;
    } // solution
    
    public void dfs(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            } // if
        } // for
        
    } // dfs
}