package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = sToI(br.readLine());
        int[] input = new int[N];

        for(int i=0 ; i<N ; i++) input[i] = sToI(br.readLine());

        Arrays.sort(input);
        long total = 0;

        for(int i=1 ; i<=N ; i++) {
            total += Math.abs(i-input[i-1]);
        }

        System.out.println(total);
    }
    static int sToI(String s) {
        return Integer.parseInt(s);
    }
}
