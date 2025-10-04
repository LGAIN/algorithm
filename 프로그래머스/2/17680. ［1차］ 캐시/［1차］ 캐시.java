import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;
        
        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();
        
        for (String city : cities) {
            city = city.toLowerCase();
                
            if (cache.remove(city)) {
                answer++;
            } else{
                answer += 5;
                if (cache.size() == cacheSize) {
                    cache.removeFirst();   
                }
            }
            cache.add(city);
        }
        
        return answer;
    }
}