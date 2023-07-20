package BOJ.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ_1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Ramen> pq = new PriorityQueue<>();

        for(int i=0 ; i<N ; i++) {
            int[] input = sToIntArray(br.readLine());
            pq.offer(new Ramen(input[0], input[1]));
        }

        PriorityQueue<Integer> ramenPq = new PriorityQueue<>();
        while(!pq.isEmpty()) {
            Ramen r = pq.poll();
            ramenPq.offer(r.ea);
            if(r.deadline < ramenPq.size()) ramenPq.poll();
        }
        System.out.println();

        int answer = 0;
        while(!ramenPq.isEmpty()) {
            answer += ramenPq.poll();
        }
        System.out.println(answer);
    }

    private static int[] sToIntArray(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Ramen implements Comparable<Ramen> {
    int deadline, ea;

    Ramen(int deadline, int ea) {
        this.deadline = deadline;
        this.ea = ea;
    }

    @Override
    public int compareTo(Ramen o) {
        return this.deadline - o.deadline;
    }
}