import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer>[] lanes = new Stack[board.length];
    
        for (int i = 0; i < board.length; i++) {
            lanes[i] = new Stack<>();
        }
        
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }
        
        
        Stack<Integer> bucket = new Stack<>();
    
        for (int m : moves) {
            if (!lanes[m - 1].isEmpty()) {
                // 해당 열에 인형이 있는 경우
                int doll = lanes[m - 1].pop();
                
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }
        
        return answer;
    }
}