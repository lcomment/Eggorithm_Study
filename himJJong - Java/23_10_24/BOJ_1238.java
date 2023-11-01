import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BOJ_1238 {
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
    static List<List<Node>> list = new ArrayList<>();
    static List<List<Node>> reverselist = new ArrayList<>();
    static String[] NM;
    static boolean[] visited;
    static int goal;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NM = br.readLine().split(" ");

        goal = Integer.parseInt(NM[2]);
        for(int i=0; i<=Integer.parseInt(NM[0]); i++){
            list.add(new ArrayList<>());
            reverselist.add(new ArrayList<>());
        }

        for(int i=0; i<Integer.parseInt(NM[1]); i++){
            String[] tmp = br.readLine().split(" ");

            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            int w = Integer.parseInt(tmp[2]);

            list.get(from).add(new Node(to,w));
            reverselist.get(to).add(new Node(from,w));
        }

        int[] dist = dijkstra(list);
        int[] dist2 = dijkstra(reverselist);


        int sum = 0;
        for(int i=1; i<=Integer.parseInt(NM[0]); i++){
            sum = Math.max(sum, dist[i] + dist2[i]);
        }
        System.out.println(sum);
    }

    private static int[] dijkstra(List<List<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        visited = new boolean[Integer.parseInt(NM[0])+1];
        pq.add(new Node(goal,0));
        int[] dist = new int[Integer.parseInt(NM[0])+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[goal] = 0;

        while(!pq.isEmpty()){
            Node tmp = pq.poll();
            if(!visited[tmp.val]){
                visited[tmp.val] = true;
                for(Node k : list.get(tmp.val)){
                    if(!visited[k.val] && dist[k.val] > k.w + dist[tmp.val]){
                        dist[k.val] = k.w + dist[tmp.val];
                        pq.add(new Node(k.val, dist[k.val]));
                    }
                }
            }

        }
        return dist;
    }
}
