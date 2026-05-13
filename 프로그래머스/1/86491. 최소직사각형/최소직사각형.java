import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int W = 0;
        int H = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            
            W = Math.max(W, w);
            H = Math.max(H, h);
        }
        
        answer = W * H;
        return answer;
    }
}