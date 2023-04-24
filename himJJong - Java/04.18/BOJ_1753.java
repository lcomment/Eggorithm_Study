import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class BOJ_1753 {
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] check;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        check = new boolean[n+1];
        dist = new int[n+1];
        for (int i = 1; i < graph.length; i++)  {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.offer(new Node(start, 0));
        //다익스트라 알고리즘 수행
        Dijkstra();

        for(int i=1; i<=n; i++){
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
    public static void Dijkstra() {
        while(!pq.isEmpty()) {
            Node nowVertex = pq.poll();

            if(check[nowVertex.index]) continue;
            check[nowVertex.index] = true;

            for(Node next : graph[nowVertex.index]) {
                if(dist[next.index] > nowVertex.cost+ next.cost) {
                    dist[next.index] = nowVertex.cost + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }
}