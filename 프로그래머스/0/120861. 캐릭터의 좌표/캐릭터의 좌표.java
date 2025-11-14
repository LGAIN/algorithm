class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < keyinput.length; i++) {
            if (keyinput[i].equals("up")) {
                if (y < board[1] / 2) y++;
            } else if (keyinput[i].equals("down")) {
                if (y > -board[1] / 2) y--;
            } else if (keyinput[i].equals("left")) {
                if (x > -board[0] / 2) x--;
            } else if (keyinput[i].equals("right")) {
                if (x < board[0] / 2) x++;
            }
        }
        return new int[] {x, y};
    }
}