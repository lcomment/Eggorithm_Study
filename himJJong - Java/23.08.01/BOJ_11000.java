import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11000 {
    static class Node implements Comparable<Node>{
        int start;
        int end;

        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o){
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        Node[] lecture = new Node[N];

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            lecture[i] = new Node(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }

        Arrays.sort(lecture);
        pq.offer(lecture[0].end);

        for(int i=1; i<N; i++){
            if(pq.peek() <= lecture[i].start){
                pq.poll();
            }
            pq.add(lecture[i].end);
        }
        System.out.println(pq.size());
    }
}
