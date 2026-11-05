import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int alphabetIdx = c - 'a';
            
            if (lastIdx[alphabetIdx] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - lastIdx[alphabetIdx];
            }
            
            lastIdx[alphabetIdx] = i;
        }
        
        return answer;
    }
}