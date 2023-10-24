import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_17936 {
    static class Node implements Comparable<Node>{
        int city;
        long w;
        Node(int city, long w){
            this.city = city;
            this.w = w;
        }
        public int compareTo(Node o){
            return Long.compare(this.w,o.w);
        }
    }
    static long[] dist;
    static List<Node>[] list;
    static int[] visible;
    static boolean[] visited;
    static int N;
    static int M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        dist = new long[N];
        visible = new int[N];
        visited = new boolean[N];
        list = new ArrayList[N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        String[] tmp = br.readLine().split(" ");
        for(int i=0; i<tmp.length; i++){
            visible[i] = Integer.parseInt(tmp[i]);
        }

        for(int i=0; i<M; i++){
            String[] data = br.readLine().split(" ");
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            int w = Integer.parseInt(data[2]);

            list[a].add(new Node(b,w));
            list[b].add(new Node(a,w));
        }
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        long answer = dijkstra(0,N-1);

        if(answer == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node tmp = pq.poll();

            if(!visited[tmp.city] && (visible[tmp.city] == 0)){
                visited[tmp.city] = true;

                for(Node k : list[tmp.city]){
                    if(!visited[k.city] && ((visible[k.city] == 0) || (k.city == N-1)) && dist[k.city] > dist[tmp.city] + k.w){
                        dist[k.city] = dist[tmp.city] + k.w;
                        pq.add(new Node(k.city, dist[k.city]));
                    }
                }
            }
        }
        return dist[end];
    }
}
