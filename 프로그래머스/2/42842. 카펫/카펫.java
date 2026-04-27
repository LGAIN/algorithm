class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        int width = 0; // 가로
        int hight = 0; // 세로
        
        // 조건 1) width * hight == brown + yellow
        // 조건 2) width >= hight
        // 조건 3) (가로 - 2) * (세로 - 2) == yellow
        
        for (int w = 3; w < (brown) / 2 ; w++) {
            for (int h = 3; h < (brown) / 2 ; h++) {
                if (w * h == brown + yellow && w >= h 
                        && (w - 2) * (h - 2) == yellow) {
                    width = w;
                    hight = h;
                    break;
                }
            }
        }
        
        return new int [] {width, hight};
    } // solution
} // Solution













// class Solution {
//     public int[] solution(int brown, int yellow) {
//         int[] answer = {};
//         int total = brown + yellow;
        
//         for (int w = (total); w >= 3 ; w--) {
//             if (total % w != 0) continue;
            
//             int h = total / w;
            
//             if (w < h) continue;
            
//             if ((w - 2) * (h - 2) == yellow) {
//                 return new int[] {w, h};
//             }
            
//         }
//         return new int[] {0, 0};
//     }
// }