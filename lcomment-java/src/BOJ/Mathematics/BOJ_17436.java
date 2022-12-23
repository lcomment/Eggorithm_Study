package BOJ.Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_17436 {
    static long N, M, result = 0;
    static long gop;
    static long[] primes;
    static Stack<Integer> picked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] NM = sToLongArr(br.readLine());
        N = NM[0];
        M = NM[1];
        primes = sToLongArr(br.readLine());
        picked = new Stack<>();

        for(int i=1 ; i<=N ; i++) {
            go(-1, i);
        }

        System.out.println(result);
    }
    private static void go(int start, int toPick) {
        if(toPick == 0) {
            gop = 1;

            for(int i : picked) {
                gop *= primes[i];
            }

            if(picked.size() % 2 == 1) {
                result += M / gop;
            } else {
                result -= M / gop;
            }
            return;
        }

        for(int i=start+1 ; i<N ; i++) {
            picked.push(i);
            go(i, toPick - 1);
            picked.pop();
        }
    }
    private static long[] sToLongArr(String s) {
        return Arrays.stream(s.split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
    }
}
