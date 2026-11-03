import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int n : arr) {
            if (stack.isEmpty() || stack.peekLast() != n) {
                stack.addLast(n);
            }
        }
        
        return stack.stream().mapToInt(i -> i).toArray();
    }
}