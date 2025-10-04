import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1}; // 상하좌우
    static int[] dy = {1, 0, -1, 0};
    
    
    public boolean isValid(int x, int y, int n, int m, int[][] map, boolean[][] visited){
        return (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 1 && !visited[x][y]);
    }
    
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1}); // (x, y, 거리)
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            
            // 목표 지점 도착
            if (x == n - 1 && y == m - 1) return dist;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (isValid(nx, ny, n, m, maps, visited)) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, dist+1});
                }
            }
        }
        
        return -1;
    }
}