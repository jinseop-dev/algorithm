class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return Integer.compare(arr1.length, arr2.length);
        }
        
        int sum1 = 0;
        int sum2 = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        
        return Integer.compare(sum1, sum2);
    }
}