import java.util.*;

class Solution {
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        int startR = 0, startC = 0;
        int leverR = 0, leverC = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                char ch = maps[r].charAt(c);
                if (ch == 'S') {
                    startR = r; startC = c;
                } else if (ch == 'L') {
                    leverR = r; leverC = c;
                }
            }
        }
        
        int toLever = bfs(startR, startC, 'L', maps, n, m);
        if (toLever == -1) return -1;
        
        int toExit = bfs(leverR, leverC, 'E', maps, n, m);
        if (toExit == -1) return -1;
        
        return toLever + toExit;
    }
    
    private int bfs(int startR, int startC, char target, String[] maps, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        
        visited[startR][startC] = true;
        queue.offer(new int[] {startR, startC, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int time = current[2];
            
            if (maps[r].charAt(c) == target) {
                return time;
            }
            
            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                
                if (maps[nr].charAt(nc) == 'X' || visited[nr][nc]) {
                    continue;
                }
                
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc, time + 1});
            }
        }
        
        return -1;
    }
}