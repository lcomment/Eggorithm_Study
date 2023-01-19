import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    public int index;
    public int value;

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Pair pair) {
        if(this.value < pair.value) {
            return 1;
        } else if (this.value > pair.value) {
            return -1;
        }
        return 0;
    }
}


public class BOJ_1826 {
    static int arrive, currentGas;
    static PriorityQueue<Pair> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] gasStations = new int[1000001];
        int[] arr;

        for(int i = 0; i < N; i++) {
            arr = inputValues(br);
            gasStations[arr[0]] = arr[1]; // 해당 주유소에서 가지고 있는 연료의 양
        }

        arr = inputValues(br);
        arrive = arr[0];
        currentGas = arr[1];

        twoPointer(gasStations);
    }

    public static int[] inputValues(BufferedReader br) throws Exception {
        return Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void twoPointer(int[] gasStations) {
        int cnt = 0;
        int end = 0;
        pq = new PriorityQueue<>();

        while(currentGas > 0) { // 기름이 남아있다면 움직일 수 있음
            end++; // index 1 증가
            currentGas--; // 가스 1감소

            if(end == arrive) { // 마을에 도착했다면
                System.out.printf("%d", cnt);
                return;
            }

            if(gasStations[end] > 0) { // 주유소라면?
                pq.add(new Pair(end, gasStations[end]));
            }

            if(currentGas == 0 && !pq.isEmpty()) { // 현재 남은 기름이 없고 주유소를 지나왔다면
                Pair pair = pq.poll();
                cnt++;
                currentGas += pair.value;
            }
        }
        System.out.printf("%d", -1);
    }
}