package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1826 {
    static class GasStation {
        int distance, amount;

        GasStation(int[] input) {
            this.distance = input[0];
            this.amount = input[1];
        }
    }
    static int N, L, P, result = 0;
    static PriorityQueue<GasStation> gQueue;
    static PriorityQueue<Integer> fQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = sToI(br.readLine());
        gQueue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        for(int i=0 ; i< N ; i++) {
            gQueue.offer(new GasStation(sToIntArray(br.readLine())));
        }

        initLP(br.readLine());
        fQueue = new PriorityQueue<>(Collections.reverseOrder());

        while (P < L) {
            while (!gQueue.isEmpty() && gQueue.peek().distance <= P) {
                fQueue.add(gQueue.poll().amount);
            }

            if (fQueue.isEmpty()) {
                System.out.println(-1);
                return;
            }

            result++;
            P += fQueue.poll();
        }

        System.out.println(result);
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void initLP(String s) {
        int[] input = sToIntArray(s);
        L = input[0];
        P = input[1];
    }
}
