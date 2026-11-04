import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        String row = "*".repeat(n) + "\n";
        
        for (int i = 0; i < m; i++) {
            sb.append(row);
        }
        
        System.out.println(sb);
    }
}