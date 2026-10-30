class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] record : db) {
            if (record[0].equals(id_pw[0])) {
                return record[1].equals(id_pw[1]) ? "login" : "wrong pw";
            }
        }
        
        return "fail";
    }
}