import java.util.*;

class Solution {
    List<Integer>[] edges;
    boolean[] visited;
    int[] nodes;
    int N;
    
    public void bfs(int start) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int now = poll[0];
            int dist = poll[1];
            nodes[now] = dist;
            
            for (int next : edges[now]) {
                if (visited[next]) continue; // 방문한 경우
                
                q.add(new int[] {next, dist + 1});
                visited[next] = true;
            }
        }
    } // bfs
    
    public int solution(int n, int[][] vertex) {
        int answer = 0;
        nodes = new int[n + 1];
        visited = new boolean[n + 1];
        N = n;
        
        edges = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        
        for (int[] connection : vertex) {
            int a = connection[0];
            int b = connection[1];
            edges[a].add(b);
            edges[b].add(a);
        }
        
        bfs(1);
        int count = 0;
        int maxDist = 0;
        for (int node : nodes) {
            if (maxDist < node) {
                maxDist = node;
                count = 1;
            } else if (maxDist == node) {
                count++;
            }
        }
        
        return count;
    } // solution
} // Soltuion