class Solution {
    int answer = 0;
    public void dfs(int i, int[] numbers, int target, int sum){
            if (i == numbers.length){
                if (sum == target) {
                    answer++;
                }   
                return;
            }
            dfs(i+1, numbers, target, sum - numbers[i]);
            dfs(i+1, numbers, target, sum + numbers[i]);    
        
        }
    
    public int solution(int[] numbers, int target) {
        int sum = 0;
        
        dfs(0, numbers, target, 0);
        
        return answer;
    }
}