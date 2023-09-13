import java.util.*;
import java.io.*;
public class BOJ_1325 {
    static int N, M, count;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        visited = new boolean[M+1];
        result = new int[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(b).add(a);
        }

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1];
            count = 0;
            bfs(i);
            result[i] = count;
            max = Math.max(count, max);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(result[i] == max){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i : list.get(tmp)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
    }
}
