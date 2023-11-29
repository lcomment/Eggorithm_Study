import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1766 {
    static int[] indegree;
    static Queue<Integer> result = new LinkedList<>();
    static List<Integer>[] list;
    static int book;
    static int data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        book = Integer.parseInt(st.nextToken());
        data = Integer.parseInt(st.nextToken());

        list = new ArrayList[book+1];
        indegree = new int[book+1];

        for(int i=0; i<book; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<data ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            list[a].add(b);
            indegree[b]++;
        }

        topologicalSort();
        System.out.println(sb);
    }

    private static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<book; i++){
            if(indegree[i] == 0){
                pq.add(i);
            }
        }

        while(!pq.isEmpty()){
            int num = pq.poll();
            sb.append((num+1) + " ");

            for(int next : list[num]) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
    }
}