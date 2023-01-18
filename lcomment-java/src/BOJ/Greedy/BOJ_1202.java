package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// PriorityQueue 삽입, 삭제 시간복잡도 : 𝑂(𝑙𝑜𝑔𝑁)
public class BOJ_1202 {

    static class Jewelry {
        int weight, value;
        Jewelry(int[] input) {
            this.weight = input[0];
            this.value = input[1];
        }
    }
    static int N, K; // 보석 개수, 가방 개수
    static PriorityQueue<Jewelry> jQueue = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
    static PriorityQueue<Integer> bQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br.readLine());

        for(int i=0 ; i<N ; i++) {
            jQueue.offer(new Jewelry(sToIntArray(br.readLine())));
        }

        for(int i=0 ; i<K ; i++) {
            bQueue.offer(sToI(br.readLine()));
        }

        long result = 0;
        PriorityQueue<Jewelry> canQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        while(!bQueue.isEmpty()) {
            int backpack = bQueue.poll();

            while(!jQueue.isEmpty() && jQueue.peek().weight <= backpack) {
                canQueue.offer(jQueue.poll());
            }

            if(!canQueue.isEmpty())
                result += canQueue.poll().value;
        }
        System.out.println(result);
    }

    private static void init(String s) {
        int[] input = sToIntArray(s);
        N = input[0];
        K = input[1];
    }

    private static int sToI(String s) {
        return Integer.parseInt(s);
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
