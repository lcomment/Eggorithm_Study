import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446 {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int dist;

        public Node(int start, int end, int dist) {
            this.start = start;
            this.end = end;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            if(this.start == o.start){
                return this.dist - o.dist;
            }
            return this.start - o.start;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> graph = new PriorityQueue<Node>();
        int[] distance = new int[D+1];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(end <= D){
                graph.add(new Node(start,end,dist));
            }
        }

        System.out.println(solution(D, graph, distance));

    }

    private static int solution(int d, PriorityQueue<Node> graph, int[] distance) {
        int cur = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while(cur < d){
            int next = cur + 1;

            if(!graph.isEmpty()){
                Node node = graph.peek();
                int start = node.start;
                int end = node.end;
                int dist = node.dist;

                if(start == cur){
                    distance[end] = Math.min(distance[cur] + dist, distance[end]);
                    graph.poll();
                }
                else{
                    distance[next] = Math.min(distance[next], distance[cur]+1);
                    cur++;
                }
            }
            else{
                distance[next] = Math.min(distance[next], distance[cur]+1);
                cur++;
            }
        }
        return distance[d];
    }
}
