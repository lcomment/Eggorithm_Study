package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17484 {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0];
        M = input[1];
        map = new int[N][M];
        // 0: 좌, 1: 직, 2: 우
        int[][][] dp = new int[N][M][3];

        for(int i=0 ; i<N ; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            /* 초기값 세팅
             * 맨 왼쪽은 오른쪽에서 올 수 없음
             * 맨 오른쪽은 왼쪽에서 올 수 없음
             */
            for(int j=0; j<M ; j++) Arrays.fill(dp[0][j], map[0][j]);
            dp[i][0][2] = Integer.MAX_VALUE;
            dp[i][M-1][0] = Integer.MAX_VALUE;
        }

        for(int i=1 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                if(in(i-1, j-1)) dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + map[i][j];

                if(in(i-1, j)) dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + map[i][j];

                if(in(i-1, j+1)) dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + map[i][j];
            }
        }
        int min = Integer.MAX_VALUE;

        for(int i=0 ; i<M ; i++){
            min = Math.min(min, Math.min(dp[N-1][i][0], Math.min(dp[N-1][i][1], dp[N-1][i][2])));
        }

        System.out.println(min);
    }
    static boolean in(int r, int c){
        return 0<=r && r<=N && 0<=c && c<M;
    }
}
