import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1916 {
    static class Node implements Comparable<Node>{
        int city;
        int w;
        Node(int city, int w){
            this.city = city;
            this.w = w;
        }

        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    static boolean[] visited;
    static List<Node>[] list;
    static int[] dist;
    static int N;
    static int M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        dist = new int[N+1];
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            String[] tmp = br.readLine().split(" ");
            int s = Integer.parseInt(tmp[0]);
            int e = Integer.parseInt(tmp[1]);
            int w = Integer.parseInt(tmp[2]);

            list[s].add(new Node(e,w));
        }

        String[] goal = br.readLine().split(" ");
        int start = Integer.parseInt(goal[0]);
        int end = Integer.parseInt(goal[1]);
        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(!visited[tmp.city]){
                visited[tmp.city] = true;

                for(Node k : list[tmp.city]){
                    if(!visited[k.city] && dist[k.city] > dist[tmp.city] + k.w){
                        dist[k.city] = dist[tmp.city] + k.w;
                        pq.add(new Node(k.city, dist[k.city]));
                    }
                }
            }
        }
        return dist[end];
    }
}
