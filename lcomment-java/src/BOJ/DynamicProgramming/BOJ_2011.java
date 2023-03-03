package BOJ.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011 {
    static String s;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        // 시작이 0이면 0 출력 후 리턴
        if(s.charAt(0) == '0') {
            System.out.println("0");
            return;
        }

        dp = new long[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2 ; i<=s.length() ; i++) {
            char cur = s.charAt(i-1);
            char prev = s.charAt(i-2); // 앞 문자

            // cur이 0일 경우 cur 앞에 1 또는 2만 가능
            if(cur == '0') {
                if(prev=='1' || prev=='2') dp[i] = dp[i-2] % 1000000;
                else break;
            } // if
            else {
                // 앞 문자가 0이면 그대로
                if(prev=='0') dp[i] = dp[i-1] % 1000000;

                    // 0이 아니면 앞 문자와 연결할 수 있는지 체크
                else {
                    // 앞 문자와 연결
                    int linkedNum = Integer.parseInt(s.substring(i-2, i));

                    if(1<=linkedNum && linkedNum<=26) dp[i] = (dp[i-2] + dp[i-1]) % 1000000;
                    else dp[i] = dp[i-1] % 1000000;
                }
            } // else
        } // for_i

        System.out.println(dp[s.length()] % 1000000);
    }
}

/* 실패 코드
 * TopDown 형식으로 풀어내려고 했음
 * 하지만 dp 테이블을 만들지 않았음
 * 또, 반례가 있는지 메모리 초과가 뜸 (아마 Exit 조건이 충분하지 않아 재귀가 계속 Heap 메모리에 쌓이면서 메모리 초과가 뜬 것으로 보임)
 */
class FailCode {
    static int count = 0;
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        recursive(0);

        System.out.println(count);
    }

    private static void recursive(int index) {
        if(index < s.length() && Character.getNumericValue(s.charAt(index)) == 0) {
            return;
        }

        if(index >= s.length() - 1) {
            count++;
            count %= 1000000;
            return;
        }

        recursive(index+1);

        int num = Integer.parseInt(s.substring(index, index+2));
        if(1<=num && num<=26) {
            recursive(index+2);
        }
    }
}
