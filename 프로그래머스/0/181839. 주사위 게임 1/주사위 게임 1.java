class Solution {
    public int solution(int a, int b) {
        int oddCount = (a % 2) + (b % 2);
        
        if (oddCount == 2) {
            return a * a + b * b;
        } else if (oddCount == 1) {
            return 2 * (a + b);
        } else {
            return Math.abs(a - b);
        }
    }
}