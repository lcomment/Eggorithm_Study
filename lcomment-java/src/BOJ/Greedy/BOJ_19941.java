package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_19941 {
    static int N, K;
    static char[] seq;
    static boolean[] ate;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0];
        K = input[1];

        seq = br.readLine().toCharArray();
        ate = new boolean[N];
        int count = 0;

        for(int i=0 ; i<N ; i++) {
            if(seq[i] == 'H') continue;

            if(check(i)) count++;
        }
        System.out.println(count);
    }

    // 본인이 먹을 수 있는 범위에서 제일 앞에 있는거를 먹음
    static boolean check(int idx) {
        int start, end;

        // 인덱스 아웃 에러 방지
        start = Math.max(idx - K, 0);
        end = Math.min(idx + K, N-1);

        for(int i= start ; i<=end ; i++){
            // 햄버거이면서 아무도 안먹었으면 먹고 리턴
            if(seq[i] == 'H' && !ate[i]){
                ate[i] = true;
                return true;
            }
        }
        return false;
    }
}
