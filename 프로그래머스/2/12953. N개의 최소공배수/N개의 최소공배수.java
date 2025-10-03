class Solution {
    // 최대 공약수 (GCD)
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    // 최소 공배수 (LCM)
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    
    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
}