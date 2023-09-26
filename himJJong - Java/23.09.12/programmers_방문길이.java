import java.util.*;

class programmers_방문길이 {
    static int answer = 0;
    static int[][] map = new int[11][11];
    static boolean[][] visited = new boolean[11][11];
    static int meX = 5;
    static int meY = 5;
    static HashMap<String, Integer> hmap = new HashMap<>();
    public int solution(String dirs) {
        String[] tmp = dirs.split("");
        for(int i=0; i<dirs.length(); i++){
            String first = String.valueOf(meX) + String.valueOf(meY);
            boolean flag = false;
            if(tmp[i].equals("U")){
                if(meX - 1>= 0){
                    meX--;
                }
                else flag = true;
            }
            else if(tmp[i].equals("D")){
                if(meX + 1 <= 10){
                    meX++;
                }
                else flag = true;
            }
            else if(tmp[i].equals("L")){
                if(meY - 1 >= 0){
                    meY--;
                }
                else flag = true;
            }
            else if(tmp[i].equals("R")){
                if(meY + 1 <= 10){
                    meY++;
                }
                else flag = true;
            }
            if(flag)    continue;
            if(!hmap.containsKey(first+String.valueOf(meX) + String.valueOf(meY)) && !hmap.containsKey(String.valueOf(meX) + String.valueOf(meY)+first)){
                hmap.put(first+String.valueOf(meX) + String.valueOf(meY),0);
                hmap.put(String.valueOf(meX) + String.valueOf(meY) + first,0);
                answer++;
            }
        }
        return answer;
    }
}