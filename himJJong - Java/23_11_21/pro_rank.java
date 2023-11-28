import java.util.*;

class pro_rank {
    public int solution(int n, int[][] results) {
        boolean[][] wins = new boolean[n+1][n+1];
        boolean[][] loses = new boolean[n+1][n+1];
        int answer = 0;

        for(int[] result : results){
            wins[result[0]][result[1]] = true;
            loses[result[1]][result[0]] = true;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                for(int k=1; k<n+1; k++){
                    if(wins[i][k] && wins[k][j]){
                        wins[i][j] = true;
                        loses[j][i] = true;
                    }
                    if(loses[i][k] && loses[k][j]){
                        wins[j][i] = true;
                        loses[i][j] = true;
                    }
                }
            }
        }

        for(int i=1; i<n+1; i++){
            int tmp = 0;
            for(int j=1; j<n+1; j++){
                if(loses[i][j] || wins[i][j])   tmp++;
            }
            if(tmp == n-1)  answer++;
        }
        return answer;
    }
}