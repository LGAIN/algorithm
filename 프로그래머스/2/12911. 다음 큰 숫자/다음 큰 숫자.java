class Solution {
    public int solution(int n) {
        
        int targetCount = Integer.bitCount(n);
        int candidate = n + 1;
        
        while (true) {
            if (Integer.bitCount(candidate) == targetCount) {
                return candidate;
            }
            candidate++;
        }
        
    }
}