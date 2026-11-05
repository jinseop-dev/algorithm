import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerToIdx = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            playerToIdx.put(players[i], i);
        }
        
        for (String calling : callings) {
            int idx = playerToIdx.get(calling);
            
            String prevPlayer = players[idx - 1];
            players[idx - 1] = calling;
            players[idx] = prevPlayer;
            
            playerToIdx.put(calling, idx - 1);
            playerToIdx.put(prevPlayer, idx);
        }
        
        return players;
    }
}