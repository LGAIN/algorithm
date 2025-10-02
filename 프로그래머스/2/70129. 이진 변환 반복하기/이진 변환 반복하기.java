class Solution {
    public int[] solution(String s) {
        int countZero = 0;
        int countTransform = 0;
        
        while (!s.equals("1")) {
            countTransform++;
            
            int beforeLength = s.length();
            String noZero = s.replace("0", "");
            int afterLength = noZero.length();
            countZero += beforeLength - afterLength;
            
            s = Integer.toBinaryString(afterLength);
        }
        
        return new int[] {countTransform, countZero};
    }
}