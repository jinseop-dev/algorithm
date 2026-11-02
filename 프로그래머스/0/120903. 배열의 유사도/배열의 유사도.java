import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String[] s1, String[] s2) {
        Set<String> set = new HashSet<>(Arrays.asList(s2));
        
        return (int) Arrays.stream(s1)
                     .filter(set::contains)
                     .count();
    }
}