import java.util.*;

class Solution {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (maps[i].charAt(j) == 'X' || visited[i][j]) {
                    continue;
                }
                
                result.add(bfs(maps, visited, i, j, n, m));
            }
        }
        
        if (result.isEmpty()) {
            return new int[] {-1};
        }
        
        return result.stream()
                   .mapToInt(Integer::intValue)
                   .sorted()
                   .toArray();
    }
    
    private int bfs(String[] maps, boolean[][] visited, int r, int c, int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new int[] {r, c});
        
        int sum = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int cr = current[0];
            int cc = current[1];
            
            sum += maps[cr].charAt(cc) - '0';
            
            for (int dir = 0; dir < 4; dir++) {
                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }
                
                if (maps[nr].charAt(nc) == 'X' || visited[nr][nc]) {
                    continue;
                }
                
                visited[nr][nc] = true;
                queue.offer(new int[] {nr, nc});
            }
        }
        
        return sum;
    }
}