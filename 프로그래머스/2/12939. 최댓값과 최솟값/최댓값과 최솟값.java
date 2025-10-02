class Solution {
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String n : nums) {
            int number = Integer.parseInt(n);
            if (number < min) {
                min = number;
            } 
            if (number > max) {
                max = number;
            }
        }
        
        answer = min + " " + max;
        return answer;
    }
}