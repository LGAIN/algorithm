import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프 구성
        for (int[] r : road) {
            int a = r[0], b = r[1], c = r[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        
        // 거리 배열 (최단 거리 저장)
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        // 우선 순위 큐 (거리기준 오름차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int node = now[0];
            int cost = now[1];
            
            // 이미 더 짧은 거리로 방문했으면 skip
            if (cost > dist[node]) continue;
            
            for (int[] next : graph.get(node)) {
                int nextNode = next[0];
                int nextCost = cost + next[1];
                
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new int[]{nextNode, nextCost});
                }
            } 
        }
        
        // K 이하인 마을 개수 세기
        for (int i = 1; i <=N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}