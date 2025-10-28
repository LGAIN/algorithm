class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int spot = -1;
        for (String name : seoul) {
            spot++;
            if (name.equals("Kim")) {
                break;
            }
        }
        return "김서방은 " + spot + "에 있다";
    }
}