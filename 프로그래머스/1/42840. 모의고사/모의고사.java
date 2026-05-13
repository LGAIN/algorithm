class Solution {
    public int[] solution(int[] answers) {
        
        int[] student_1 = {1, 2, 3, 4, 5}; // 5
        int[] student_2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] student_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        int[] score = {0, 0, 0};
        
        
        for (int i = 0; i < answers.length; i++) {
            int pattern_1 = i % 5;
            int pattern_2 = i % 8;
            int pattern_3 = i % 10;
            if (student_1[pattern_1] == answers[i]) {
                score[0]++;
            }
            if (student_2[pattern_2] == answers[i]) {
                score[1]++;
            }
            if (student_3[pattern_3] == answers[i]) {
                score[2]++;
            }
        }
        
        int max_score = 0;
        int size = 0;
        max_score = Math.max(score[0], Math.max(score[1], score[2]));
        
        for (int i = 0; i < 3; i++) {
            if (score[i] == max_score) {
                size++;
            }
        }
        int[] answer = new int[size];
        
        
        for (int i = 0; i < 3; i++) {
            if (score[i] == max_score) {
                for (int j = 0; j < size; j++) {
                    if (answer[j] == 0) {
                        answer[j] = i+1;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}