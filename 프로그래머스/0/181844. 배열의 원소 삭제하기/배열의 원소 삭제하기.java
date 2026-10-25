import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Set<Integer> set = Arrays.stream(delete_list)
                                 .boxed()
                                 .collect(Collectors.toSet());
        
        return Arrays.stream(arr)
                     .filter(n -> !set.contains(n))
                     .toArray();
    }
}