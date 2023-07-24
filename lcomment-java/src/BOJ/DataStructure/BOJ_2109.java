package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_2109 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Seminar> pq = new PriorityQueue<>((o1, o2) -> o1.day - o2.day);

        for(int i=0 ; i<N ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            pq.offer(new Seminar(input[0], input[1]));
        }

        PriorityQueue<Integer> payPq = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            Seminar s = pq.poll();
            payPq.offer(s.pay);
            if(s.day < payPq.size()) payPq.poll();
        }

        int answer = 0;
        while(!payPq.isEmpty()) {
            answer += payPq.poll();
        }
        System.out.println(answer);
    }
}

class Seminar {
    int day;
    int pay;

    Seminar(int pay, int day) {
        this.pay = pay;
        this.day = day;
    }
}
