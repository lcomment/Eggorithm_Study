import java.io.*;
import java.util.*;

public class BOJ_9934 {
    static int K;
    static int[] arr;
    static StringBuilder[] ans;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        arr = new int[(int) Math.pow(2, K) - 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        ans = new StringBuilder[K];

        for (int i = 0; i < K; i++){
            ans[i] = new StringBuilder();
        }

        solve(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++){
            System.out.println(ans[i]);
        }
    }

    public static void solve(int s, int e, int floor) {

        if (floor == K) return;

        int m = (s + e) / 2;
        ans[floor].append(arr[m]).append(" ");

        solve(s, m - 1, floor + 1); // 루트 노드의 왼쪽
        solve(m + 1, e, floor + 1); // 루트 노드의 오른쪽
    }
}