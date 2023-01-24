import java.io.*;
import java.util.*;

class Coin {
    int value, quantity;
    Coin(int value, int quantity) {
        this.value = value;
        this.quantity = quantity;
    }
}

public class BOJ_1943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = 3;
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[n+1];  // 원장님이 주는 금액의 최대는 10만원
            boolean[] dp = new boolean[100001];  // i원 만들기 가능?

            int total = 0;
            for(int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                coins[i] = new Coin(value, quantity);
                total += value * quantity;  // 받은 총 금액 구함
                for(int j = 1; j <= quantity; j++) {
                    dp[value * j] = true;  // 각 종류의 동전으로 만들 수 있는 액수 먼저 체크
                }
            }

            // 굳이 dp[] 다 안 채워도 되는 경우
            if(total % 2 == 1) {
                System.out.println(0);
                continue;
            }else if(dp[total / 2]) {
                System.out.println(1);
                continue;
            }

            // 주어진 동전으로 (total / 2)원을 만들 수 있는지 확인하면 될 듯?
            dp[0] = true;
            for(int i = 1; i <= n; i++) {
                int v = coins[i].value;
                int q = coins[i].quantity;

                for(int j = total/2; j >= v; j--) {
                    if(dp[j - v]) {  // dp[j-v]가 가능해야 거기에 동전 하나씩 더해서 다음 액수를 가능하게 만들지

                        // (j-v)원부터 동전 v를 하나씩 사용하는 것
                        for(int k = 1; k <= q; k++) {
                            if(j - v + v * k > total/2) break;  // dp[total/2] 이상으로는 어차피 채울 필요 없음
                            dp[j - v + v * k] = true;
                        }
//                        // 이게 이말임
//                        for(int k = 0; k < quantity; k++) {
//                            dp[j + value * k] = true;
//                        }
                    }
                }
            }
            System.out.println(dp[total / 2] ? 1 : 0);
        }
    }
}