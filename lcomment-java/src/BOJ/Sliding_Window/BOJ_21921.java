package BOJ.Sliding_Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class BOJ_21921 {
    static int N, R;
    static int[] seq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = sToIntArray(br.readLine());
        N = input[0];
        R = input[1];
        seq = sToIntArray(br.readLine());

        int left = 0;
        int right = R-1;
        int sum = initSum(right);
        int cur = sum;
        int count = sum != 0 ? 1:0;

        while(right < N-1 && left <= right) {
            cur = cur - seq[left++] + seq[++right];

            if(cur > sum) {
                sum = cur;
                count = 1;
            } else if(cur == sum && sum != 0) {
                count++;
            } else {
                continue;
            }
        }

        if(count != 0) {
            System.out.println(sum);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
    }

    private static int initSum(int right) {
        return IntStream.rangeClosed(0, right).map(i -> seq[i]).sum();
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}