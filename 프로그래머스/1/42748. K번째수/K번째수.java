import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            int length = commands[i][1] - commands[i][0] + 1;
            int[] temp = new int[length];
            int idx = 0;
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                temp[idx] = array[j];
                idx++;
            }
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
            
        }
        
        return answer;
    } // solution
} // Solution









// import java.util.*;

// class Solution {
//     public int[] solution(int[] array, int[][] commands) {
//         int[] answer = new int[commands.length];
        
//         for (int i = 0; i < commands.length; i++) {
//             int start = commands[i][0] - 1;
//             int end = commands[i][1];
//             int k = commands[i][2] - 1;
            
//             // 배열 추출
//             int[] temp = Arrays.copyOfRange(array, start, end);
//             Arrays.sort(temp);
//             answer[i] = temp[k];
//         }
//         return answer;
//     }
// }