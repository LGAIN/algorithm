import java.util.*;

class Solution {
    
    boolean[] visited;
    
    public void dfs(int i, int[][] computers) {
        for (int a = 0; a < computers.length; a++) {
            if (i != a && computers[i][a] == 1 && !visited[a]) {
                visited[a] = true;
                dfs(a, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        
        return answer;
     } // solution
} // Solution
















// import java.util.*;

// class Solution {
    
//     static boolean[] visited;
    
//     public static void dfs(int x, int n, int[][] computers) {
//         visited[x] = true;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i] && computers[x][i] == 1) {
//                 visited[i] = true;
//                 dfs(i, n, computers);
//             }
//         }
//     }
    
    
//     public int solution(int n, int[][] computers) {
//         int answer = 0;
//         visited = new boolean[n];
        
//         for (int i = 0; i < n; i++) { 
//             for (int j = 0; j < n; j++) {
//                 if (!visited[i] && computers[i][j] == 1) {
//                     dfs(i, n, computers);
//                     answer++;
//                 }
//             }
//         }
//         return answer;
//     }
// }