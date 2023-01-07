package BOJ.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13144 {
    static int N;
    static long result;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = sToI(br.readLine());
        seq = sToIntArray(br.readLine());

        int left = 1;
        int right = 0;
        int[] count = new int[100_001];

        while(left <= N) {
            while(right + 1 <= N && count[seq[right + 1]] == 0) {
                count[seq[++right]]++;
            }

            result += right - left + 1;
            count[seq[left++]]--;
        }
        System.out.println(result);
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArray(String s) {
        int[] input = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = new int[input.length + 1];

        for(int i=1 ; i<arr.length ; i++) {
            arr[i] = input[i-1];
        }
        return arr;
    }
}
