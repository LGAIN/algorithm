import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if ((remain % speeds[i]) != 0) day++;
            days.add(day);
        }
        
        int first = days.poll();
        int count = 1;
        
        while (!days.isEmpty()) {
            int curr = days.poll();
            
            if (curr <= first) {
                count++;
            } else {
                result.add(count);
                count = 1;
                first = curr;
            }
        }
        
        result.add(count);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}