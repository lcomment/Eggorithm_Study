package BOJ.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3020 {
    static int N, H;
    static int[] top, bottom;
    static int min = Integer.MAX_VALUE, count = 0;

    public static void main(String[] args) throws IOException {
        init();

        for(int i=0 ; i<H ; i++) {
            int breakWall = binarySearch(bottom, 0, N/2, i) + binarySearch(top, 0, N/2, H-i+1);

            if(min == breakWall) {
                count++;
            } else if(min > breakWall) {
                min = breakWall;
                count = 1;
            }
        }
        System.out.println(min + " " + count);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        N = input[0];
        H = input[1];
        bottom = new int[N/2];
        top = new int[N/2];

        for(int i=0 ; i<N/2 ; i++) {
            bottom[i] = stoi(br.readLine());
            top[i] = stoi(br.readLine());
        }

        Arrays.sort(top);
        Arrays.sort(bottom);
    }

    private static int binarySearch(int[] arr, int left, int right, int line) {
        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] >= line) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return arr.length - right;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

}