package BOJ.Bit_Masking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_16938 {
    static int N, L, R, X, result = 0;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        init();


        for(int bit = 0 ; bit < (1<<N) ; bit++) {
            if(check(bit)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean check(int bit) {
        int cntQuiz = 0, score = 0;
        int maxScore = Integer.MIN_VALUE;
        int minScore = Integer.MAX_VALUE;

        for(int i=0 ; i<N ; i++) {
            int flag = bit & (1<<i);

            // & 연산으로 선택된 문제 확인 (1이면 선택된 문제)
            if(flag == 0) continue;

            score += seq[i];
            maxScore = Math.max(maxScore, seq[i]);
            minScore = Math.min(minScore, seq[i]);
            cntQuiz++;
        }

        // 조건에 맞는지 체크
        if(L<=score && score<=R && maxScore-minScore>=X && cntQuiz>=2) {
            return true;
        }
        return false;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = sToIntArray(br.readLine());
        N = input[0];
        L = input[1];
        R = input[2];
        X = input[3];

        seq = sToIntArray(br.readLine());
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
