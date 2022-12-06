package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 오답
 * 예외 케이스: 10 5 5
 * out: 1 2 3 4 5 5 4 3 2 1
 * ans: 1 1 2 3 4 5 4 3 2 1
 */
public class BOJ_24337 {
    static int N, a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = input[0];
        a = input[1];
        b = input[2];

        if (a + b > N + 1){
            System.out.println(-1);
            return;
        }

        int[] buildings = new int[N];
        Arrays.fill(buildings, N);

        for(int i=a-2 ; i>=0 ; i--){
            buildings[i] = buildings[i+1] - 1;
        }

        for(int i=N-b+1 ; i<N ; i++){
            buildings[i] = buildings[i-1] - 1;
        }

        int n = Math.min(buildings[0] - 1, buildings[N-1] - 1);

        for(int building : buildings){
            System.out.print((building - n) + " ");
        }
    }
}
