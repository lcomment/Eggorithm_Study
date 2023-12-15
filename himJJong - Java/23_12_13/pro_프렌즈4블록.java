import java.util.*;

public class pro_프렌즈4블록 {
    public static void main(String[] args) {
        int m = 2;
        int n = 2;
        String[] board = {"CA", "BA"};
        System.out.println(Solution.solution(m,n,board));
    }
    static class Solution {
        static char[][] map;
        static int answer = 0;
        static public int solution(int m, int n, String[] board) {
            map = new char[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    map[i] = board[i].toCharArray();
                }
            }

            while(true){
                int count = 0;
                boolean[][] visited = new boolean[m][n];
                for(int i=0; i<m-1; i++){
                    for(int j=0; j<n-1; j++){
                        if(map[i][j] == '.')    continue;
                        if(check(i,j,visited)){
                            count++;
                        }
                    }
                }
                if(count == 0){
                    break;
                }
                removeBlock(m,n,visited);
                fixMap(n,m);
            }

            for(int i=0; i<m; i++){
                for(int j=0;j<n; j++ ){
                    if(map[i][j] == '.')    answer++;
                }
            }
            return answer;
        }
        private static boolean check(int x, int y, boolean[][] visited){ // 4개가 같은
            if(map[x][y] == (map[x][y+1]) && (map[x+1][y]) == (map[x+1][y+1]) && map[x][y] == map[x+1][y+1]){
                visited[x][y] = true;
                visited[x+1][y] = true;
                visited[x][y+1] = true;
                visited[x+1][y+1] = true;

                return true;
            }
            return false;
        }
        private static void removeBlock(int m, int n,boolean[][] visited){  //breakPoint에 주어진 좌표를 기준으로 벽부시기
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(visited[i][j]){
                        map[i][j] = '.';
                    }
                }
            }
        }
        private static void fixMap(int n, int m) { // 부서진 맵 요소들 내리기
            for(int i=0; i<n; i++){
                for(int j = m-1; j >= 0; j--){
                    if(map[j][i] == '.'){
                        for(int k = j-1; k>=0; k--){
                            if(map[k][i] != '.'){
                                map[j][i] = map[k][i];
                                map[k][i] = '.';
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
