import java.util.*;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.offer(new int[] {0, 0, 1});
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        while (!bfsQ.isEmpty()) {
            int[] current = bfsQ.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            if (r == n - 1 && c == m - 1) {
                return dist;
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                    if (!visited[nr][nc] && maps[nr][nc] == 1) {
                        bfsQ.offer(new int[] {nr, nc, dist + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}