import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5972 {
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
    static List<Node>[] list;
    static boolean[] visited;
    static int dist[];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];
        visited = new boolean[V+1];
        dist = new int[V+1];

        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e,w));
            list[e].add(new Node(s,w));
        }

        System.out.println(dijkstra(1,V));
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));
        Arrays.fill(dist,50000000);
        dist[1] = 0;

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
