import java.util.*;

class Solution {
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] temp = operations[i].split(" ");
            String command = temp[0];
            int number = Integer.parseInt(temp[1]);
            if (command.equals("I")) {
                map.put(number, map.getOrDefault(number, 0) + 1);
            } else if (command.equals("D") && !map.isEmpty()) {
                int key;
                if (number == 1) {
                    key = map.lastKey();
                } else {
                    key = map.firstKey();
                }
                
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(number, map.get(key) - 1);
                }
            }
            
        }
        
        if (!map.isEmpty()) {
            answer[0] = map.lastKey();
            answer[1] = map.firstKey();
        }
        
        return answer;
    } // solution
} // Solution