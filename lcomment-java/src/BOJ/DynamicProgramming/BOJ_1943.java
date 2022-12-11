package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1943 {
    static class Coin {
        int value;
        int cnt;
        Coin(int value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 3;

        while(T-- > 0) {
            // 코인의 종류
            int N = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[N+1];
            boolean[] dp = new boolean[100_001];

            dp[0] = true;
            int total = 0;

            for(int i=1 ; i<=N ; i++) {
                int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                coins[i] = new Coin(input[0], input[1]);
                total += input[0] * input[1];

                for(int j=1 ; j<=input[1] ; j++) {
                    dp[j*input[0]] = true;
                }
            }

            // 1원이 남거나 이미 나눌 수 있는 경우
            if(total % 2 == 1) {
                System.out.println(0);
                continue;
            }
            if(dp[total/2]) {
                System.out.println(1);
                continue;
            }

            for(int i=1 ; i<=N ; i++) {
                int value = coins[i].value;
                int cnt = coins[i].cnt;

                for(int j=total/2 ; j>=value ; j--) {
                    if(dp[j - value]){
                        for(int k = 1; k <= cnt; k++) {
                            if((j - value) + (value * k) > total/2) break;  // dp[total/2] 이상으로는 계산 X

                            dp[(j - value) + (value * k)] = true;
                        } // for_k
                    }
                } // for_j
            } // for_i
            System.out.println(dp[total/2] ? 1:0);
        } // while-T
    }
}
