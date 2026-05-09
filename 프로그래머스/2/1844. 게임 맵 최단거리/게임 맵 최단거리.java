import java.util.*;

class Solution {
    int n;
    int m;
    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};
    boolean[][] visited;
    int answer;
    int count;
    
    public void bfs(int x, int y, int[][] maps) {
        visited[x][y] = true;
        count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y, count});
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cc = curr[2];
            for (int i = 0; i < 4; i++) {    
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (isValid(nx, ny) && !visited[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new int[] {nx, ny, cc + 1});
                    visited[nx][ny] = true;
                    if (nx == n - 1 && ny == m - 1) {
                        answer = cc + 1;
                        return;
                    }
                }
            }
            
        }
        
    } // bfs
    
    public boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m; 
    }
    
    
    public int solution(int[][] maps) {
        answer = -1;
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        // maps 의 원소가 0 : 벽
        // maps 의 원소가 1 : 길
        
        bfs(0, 0, maps);
        return answer;
    } // solution
} // Solution















// import java.util.*;

// class Solution {
//     static int[] dx = {0, 1, 0, -1}; // 상하좌우
//     static int[] dy = {1, 0, -1, 0};
    
    
//     public boolean isValid(int x, int y, int n, int m, int[][] map, boolean[][] visited){
//         return (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 1 && !visited[x][y]);
//     }
    
    
//     public int solution(int[][] maps) {
//         int n = maps.length;
//         int m = maps[0].length;
//         boolean[][] visited = new boolean[n][m];
        
//         Queue<int[]> queue = new LinkedList<>();
//         queue.add(new int[] {0, 0, 1}); // (x, y, 거리)
//         visited[0][0] = true;
        
//         while (!queue.isEmpty()) {
//             int[] now = queue.poll();
//             int x = now[0];
//             int y = now[1];
//             int dist = now[2];
            
//             // 목표 지점 도착
//             if (x == n - 1 && y == m - 1) return dist;
            
//             for (int i = 0; i < 4; i++) {
//                 int nx = x + dx[i];
//                 int ny = y + dy[i];
                
//                 if (isValid(nx, ny, n, m, maps, visited)) {
//                     visited[nx][ny] = true;
//                     queue.add(new int[] {nx, ny, dist+1});
//                 }
//             }
//         }
        
//         return -1;
//     }
// }