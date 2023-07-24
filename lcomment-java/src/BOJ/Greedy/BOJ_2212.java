package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2212 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(br.readLine());
        int K = stoi(br.readLine());
        int[] sensors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(sensors);

        int[] distance = new int[N-1];
        for(int i=0 ; i<N-1 ; i++) {
            distance[i] = sensors[i+1] - sensors[i];
        }

        Arrays.sort(distance);

        int answer = 0;
        for(int i=0 ; i<N-K ; i++) {
            answer += distance[i];
        }
        System.out.println(answer);
    }

    private static int stoi(String s) {
         return Integer.parseInt(s);
    }
}
