class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        
        int limitX = board[0] / 2;
        int limitY = board[1] / 2;
        
        for (String key : keyinput) {
            switch (key) {
                case "up"    -> y = Math.min(limitY, y + 1);
                case "down"  -> y = Math.max(-limitY, y - 1);
                case "left"  -> x = Math.max(-limitX, x - 1);
                case "right" -> x = Math.min(limitX, x + 1);
            }
        }
        
        return new int[] { x, y };
    }
}