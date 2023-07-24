package BOJ.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ_2559 {
    static int N, K;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = sToIntArray(br.readLine());
        N = input[0];
        K = input[1];
        seq = sToIntArray(br.readLine());

        int left = 0, right = K - 1;
        int sum = initSum(right);
        int cur = sum;

        while (right < N - 1 && left <= right) {
            cur = cur - seq[left++] + seq[++right];

            if(cur > sum) {
                sum = cur;
            }
        }

        System.out.println(sum);
    }

    private static int initSum(int right) {
        return IntStream.rangeClosed(0, right).map(i -> seq[i]).sum();
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
