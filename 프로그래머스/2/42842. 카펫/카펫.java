import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;
        
        for (int w = (total); w >= 1 ; w--) {
            if (total % w != 0) continue;
            
            int h = total / w;
            
            if (w < h) continue;
            
            if ((w - 2) * (h - 2) == yellow) {
                return new int[] {w, h};
            }
            
        }
        return new int[] {0, 0};
    }
}