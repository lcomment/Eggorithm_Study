package BOJ.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2110 {
    static int N, C;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputToNC(br.readLine());
        seq = new int[N];

        for(int i=0 ; i<N ; i++) {
            seq[i] = sToI(br.readLine());
        }
        // 1 2 4 8 9
        Arrays.sort(seq);
        int left = 1;
        int right = seq[N-1] - seq[0] + 1;

        while(left < right) {
            int mid  = calculateMid(left, right);

            if(calculateMinDistance(mid) < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left - 1);
    }

    private static int calculateMinDistance(int d) {
        int cnt = 1;
        int save = seq[0];

        for(int i=1 ; i<N ; i++) {
            int cur = seq[i];

            if(cur - save >= d) {
                cnt++;
                save = cur;
            }
        }
        return cnt;
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }
    private static void inputToNC(String s) {
        int[] NC = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        N = NC[0];
        C = NC[1];
    }

    private static int calculateMid(int x, int y) {
        return (x + y) / 2;
    }
}
