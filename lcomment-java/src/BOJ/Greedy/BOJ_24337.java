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

        Arrays.fill(buildings, 1);

        if(a == 1) {
            buildings[0] = b;
            for(int i=N-2 ; (b--)-2>0 ; i--){
                buildings[i] = buildings[i+1] + 1;
            }
        } else {
            int maxHeight = Math.max(a, b);
            int maxHeightIdx = N-b;

            buildings[maxHeightIdx] = maxHeight;
            for(int i=maxHeightIdx-1 ; --a>1 ; i--) {
                buildings[i] = a;
            }
            for(int i=maxHeightIdx+1 ; --b>1 ; i++) {
                buildings[i] = b;
            }
        }

        for(int building : buildings){
            System.out.print((building) + " ");
        }
    }
}
