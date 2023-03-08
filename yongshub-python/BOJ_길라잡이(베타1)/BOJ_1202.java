import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Jewelry {
    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class BOJ_1202 {
    static int N;
    static int K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] NM = inputValues(br);
        N = NM[0];
        K = NM[1];
        Jewelry[] jewelries = new Jewelry[N];
        int[] backpacks = new int[K];

        for(int i = 0; i < N; i++) {
            int[] jewelry = inputValues(br);
            jewelries[i] = new Jewelry(jewelry[0], jewelry[1]);
        }

        for(int i = 0; i < K; i++) {
            backpacks[i] = Integer.parseInt(br.readLine());
        }
        //보석 무게 오름차순으로 정렬
        Arrays.sort(jewelries, Comparator.comparingInt(o -> o.weight));
        //배낭 무게 오름차순으로 정렬
        Arrays.sort(backpacks);

        System.out.printf("%d", getMaxValue(jewelries, backpacks));
    }

    public static long getMaxValue(Jewelry[] jewelries, int[] backpacks) {
        long maxValue = 0;
        int jewelryIdx = 0;
        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        for(int i = 0; i < K; i++) {
            while(jewelryIdx < N && jewelries[jewelryIdx].weight <= backpacks[i]) {
                pq.add(jewelries[jewelryIdx++]);
            }
            if(!pq.isEmpty()) {
                maxValue += pq.poll().value;
            }
        }
        return maxValue;
    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}