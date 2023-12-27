import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9252 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        char[] M = br.readLine().toCharArray();

        int[][] dp = new int[S.length+1][M.length+1];
        int max = 0;

        for(int i=1; i<=S.length; i++){
            for(int j=1; j<=M.length; j++){
                if(S[i-1] == M[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }

                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        if(max == 0){
            System.out.println(0);
            System.exit(0);
        }

        int x = S.length;
        int y = M.length;

        StringBuilder a = new StringBuilder();
        Stack<String> s = new Stack<>();

        while(x != 0 && y != 0){
            if(x== 0 || y== 0)  break;

            if(dp[x][y] == dp[x-1][y]){
                x--;
            }
            else if(dp[x][y] == dp[x][y-1]){
                y--;
            }
            else{
                s.push(String.valueOf(S[x-1]));
                x--;
                y--;
            }
        }

        while(!s.isEmpty()){
            a.append(s.pop());
        }

        System.out.println(a.length());
        System.out.println(a);
    }
}