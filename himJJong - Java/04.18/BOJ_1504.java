import java.io.*;
import java.util.*;

public class BOJ_1504 {
    static class Node implements Comparable<Node>{
        int index;
        int cost;
        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static int[] NM;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Node> data[];
    static int[] promise;
    static int INF = 200000000;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dist = new int[NM[0]+1];
        visited = new boolean[NM[0]+1];
        data = new ArrayList[NM[0]+1];
        promise = new int[2];
        int ans = 0;

        for(int i=1; i<= NM[0]; i++){
            data[i] = new ArrayList<>();
        }

        for(int i=0; i<NM[1]; i++){
            int[] input = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int a = input[0];
            int b = input[1];
            int c = input[2];

            data[a].add(new Node(b,c));
            data[b].add(new Node(a,c));
        }

        promise = Arrays.stream(br.readLine().split(" "))   // 이 2개의 배열값은 무조건 거쳐야함
                .mapToInt(Integer::parseInt)
                .toArray();

        int method_a = 0;
        int method_b = 0;

        method_a += dijkstra(1,promise[0]);
        method_a += dijkstra(promise[0],promise[1]);
        method_a += dijkstra(promise[1],NM[0]);

        method_b += dijkstra(1,promise[1]);
        method_b += dijkstra(promise[1],promise[0]);
        method_b += dijkstra(promise[0],NM[0]);

        if(method_a >= INF && method_b >= INF) System.out.println(-1);
        else System.out.println(Math.min(method_a,method_b));

    }

    private static int dijkstra(int start, int end) {
        pq.offer(new Node(start,0));
        Arrays.fill(dist,INF);
        dist[start] = 0;
        Arrays.fill(visited,false);

        while(!pq.isEmpty()){
            Node tmp = pq.poll();

            if(visited[tmp.index]) continue;
            visited[tmp.index] = true;

            for(Node next : data[tmp.index]){
                if(dist[next.index] > tmp.cost + next.cost){
                    dist[next.index] = tmp.cost + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist[end];
    }
}
