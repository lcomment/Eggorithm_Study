import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1389 {
    static class Node{
        int vertex;
        int depth;
        Node(int vertex, int depth){
            this.vertex = vertex;
            this.depth = depth;
        }
    }
    static List<Integer>[] list;
    static int answer = Integer.MAX_VALUE;
    static List<Integer> answerList = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=N; i++){
            boolean[] visited = new boolean[N+1];
            int count = bfs(i,visited);
            if(count == answer){
                answerList.add(i);
            }
            else if(count < answer){
                answer = count;
                answerList.clear();
                answerList.add(i);
            }
        }

        Collections.sort(answerList);
        System.out.println(answerList.get(0));
    }

    private static int bfs(int val, boolean[] visited) {
        int count = 0;
        visited[val] = true;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(val, 0));

        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int k : list[tmp.vertex]){
                if(!visited[k]){
                    visited[k] = true;
                    count += tmp.depth+1;
                    q.add(new Node(k, tmp.depth+1));
                }
            }
        }
        return count;
    }
}
