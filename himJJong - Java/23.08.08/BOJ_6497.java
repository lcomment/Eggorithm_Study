import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_6497 {
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
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int house = Integer.parseInt(st.nextToken());
            int data = Integer.parseInt(st.nextToken());

            if(house == 0 && data == 0) break;
            long sum = 0;
            parent = new int[house];
            for(int i=0; i<house; i++){
                parent[i] = i;
            }
            List<Node> list = new ArrayList<>();

            for(int i=0; i<data; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                sum += c;
                list.add(new Node(a, b, c));
            }

            Collections.sort(list);
            long min = 0;

            for(int i=0; i<data; i++) {
                Node tmp = list.get(i);

                if (findParent(tmp.from) != findParent(tmp.to)) {
                    union(tmp.from, tmp.to);
                    min += tmp.val;
                }
            }
            sb.append(sum - min).append("\n");
        }
        System.out.print(sb);
    }

    private static void union(int from, int to) {
        from = findParent(from);
        to = findParent(to);

        if(from != to){
            if(from < to){
                parent[to] = from;
            }
            else parent[from] = to;
        }
    }

    private static int findParent(int from) {
        if(from == parent[from])    return from;
        return parent[from] = findParent(parent[from]);
    }
}
