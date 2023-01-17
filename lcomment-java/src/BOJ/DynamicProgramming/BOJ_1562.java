package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1562 {
    static final int num = 1_000_000_000;
    static int N;
    static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = sToI(br.readLine());

        // N+1 자리 숫자, x로 끝나는 숫자, y를 포함하는 숫자
        dp = new long[N+1][10][1<<10];

        for(int i=1 ; i<10 ; i++) {
            dp[1][i][1<<i] = 1;
        }

        for(int i=2 ; i<=N ; i++) {
            for(int j=0 ; j<10 ; j++) {
                for(int k=0 ; k<1024 ; k++) {
                    int bitMask = k | (1<<j);

                    // j가 0이거나 9일 때 새로운 숫자는 1이나 8밖에 올 수 없음
                    if(j == 0) {
                        dp[i][j][bitMask] = (dp[i][j][bitMask] + dp[i-1][j+1][k]) % num;
                    } else if(j == 9) {
                        dp[i][j][bitMask] = (dp[i][j][bitMask] + dp[i-1][j-1][k]) % num;
                    } else {
                        dp[i][j][bitMask] = (dp[i][j][bitMask] + dp[i-1][j+1][k] + dp[i-1][j-1][k]) % num;
                    }
                } // for_k
            } // for_j
        } // for_i

        long sum = 0;

        // N 자리수이면서 0~9를 모두 포함하고 있는 부분합의 합 구하기
        for(int i=0 ; i<10 ; i++) {
            sum += dp[N][i][1023];
            sum %= num;
        }

        System.out.println(sum);
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
