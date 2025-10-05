import java.util.*;

class Solution {
    
    public List<String> makeList(String str) {
        List<String> list = new ArrayList<>();
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length()-1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            
            if (Character.isLetter(a) && Character.isLetter(b)) {
                list.add("" + a + b);
            }
        }
        
        return list;
    }
    
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (String s : makeList(str1)){
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        
        for (String s : makeList(str2)){
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        
        int inter = 0;
        int union = 0;
        
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        
        for (String key: allKeys) {
            int count1 = map1.getOrDefault(key, 0);
            int count2 = map2.getOrDefault(key, 0);
            
            inter += Math.min(count1, count2); // 교집합
            union += Math.max(count1, count2); // 차집합
        }
        
        int answer = 0;
        if (union == 0) {
            answer = 65536;
        } else {
            answer = (int) ((double) inter / union * 65536);
        }
        return answer;
    }
}