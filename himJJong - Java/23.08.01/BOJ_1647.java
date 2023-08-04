import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1647 {
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int val;
        Node(int from, int to, int val){
            this.from = from;
            this.to = to;
            this.val = val;
        }

        @Override
        public int compareTo(Node o){
            return this.val - o.val;
        }
    }
    static int[] parent;
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int house = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());

        parent = new int[house+1];

        for(int i=1; i<=house ; i++){
            parent[i] = i;
        }

        for(int i=0; i<road; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a,b,c));
        }
        // 1-2-3-5 5  4-6  1
        Collections.sort(list);
        int answer = 0;
        int last = 0;

        for(int i=0; i<road; i++){
            Node tmp = list.get(i);

            if(findParent(tmp.from) != findParent(tmp.to)){
                union(tmp.from, tmp.to);
                answer += tmp.val;
                last = tmp.val;
            }
        }

        System.out.println(answer - last);
    }

    private static void union(int from, int to) {
        from = findParent(from);
        to = findParent(to);

        if(from != to){
            if(from > to){
                parent[from] = to;
            }
            else{
                parent[to] = from;
            }
        }
    }

    private static int findParent(int root) {
        if(root == parent[root])    {
            return root;
        }
        return parent[root] = findParent(parent[root]);
    }
}
