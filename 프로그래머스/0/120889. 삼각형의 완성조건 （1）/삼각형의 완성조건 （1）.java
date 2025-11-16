import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int max_side = Math.max(sides[0], Math.max(sides[1], sides[2]));
        int sum_side = sides[0] + sides[1] + sides[2];
        if (max_side < sum_side - max_side) {
            answer = 1;
        } else {
            answer = 2;
        }
        
        return answer;
    }
}