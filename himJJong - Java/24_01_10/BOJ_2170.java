import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2170 {
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o, Node o1){
                if(o.x == o1.x){
                    return o.y - o1.y;
                }
                return o.x - o1.x;
            }

        });
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) + 1000000000;
            int e = Integer.parseInt(st.nextToken()) + 1000000000;
            pq.add(new Node(s,e));
        }

        int answer = 0;

        Node tmp = pq.poll();
        int start = tmp.x;
        int end = tmp.y;
        while(!pq.isEmpty()){
            Node next = pq.poll();

            if(end > next.y){
                continue;
            }
            else if(end >= next.x && end <= next.y){
                end = next.y;
            }
            else{
                answer += end - start;
                start = next.x;
                end = next.y;
            }
        }

        System.out.println(answer + (end - start));
    }
}
