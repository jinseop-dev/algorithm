import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.iterate(start_num, n -> n >= end_num, n -> n - 1)
                        .toArray();
    }
}