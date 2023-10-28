import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10282 {
    static class Node implements Comparable<Node>{
        int val;
        int w;
        Node(int val, int w){
            this.val = val;
            this.w = w;
        }

        public int compareTo(Node o){
            return this.w - o.w;
        }
    }
    static int[] dist;
    static boolean[] visited;
    static List<List<Node>> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while(t-- >0){
            st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());
            int virus = Integer.parseInt(st.nextToken());

            for(int i=0; i<=com; i++){
                list.add(new ArrayList<>());
            }

            visited = new boolean[com+1];
            dist = new int[com+1];

            for(int i=0; i<edge; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.get(b).add(new Node(a,c));
            }

            dijkstra(virus);
            list.clear();
            int count = 0;
            int max = Integer.MIN_VALUE;
            for(int i=1; i<=com; i++){
                if(dist[i] != Integer.MAX_VALUE) {
                    max = Math.max(max, dist[i]);
                    count++;
                }
            }
            System.out.println(count+" "+max);
        }
    }

    private static void dijkstra(int virus) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(virus,0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[virus] = 0;

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(!visited[tmp.val]){
                visited[tmp.val] = true;
                for(Node k : list.get(tmp.val)){
                    if(!visited[k.val] && dist[k.val] > dist[tmp.val] + k.w){
                        dist[k.val] = dist[tmp.val] + k.w;
                        pq.add(new Node(k.val, dist[k.val]));
                    }
                }
            }
        }

    }
}
