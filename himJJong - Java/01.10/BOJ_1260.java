import java.io.*;
import java.util.*;

public class BOJ_1260 {
    static int[][] data;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();       //정점
        int M = sc.nextInt();       //간점
        int V = sc.nextInt();       //시작위치

        //인접행렬
        data = new int[N+1][N+1];
        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            data[a][b] = 1;
            data[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);

        visited = new boolean[N+1];
        bfs(V);
    }
    private static void dfs(int v) {
        visited[v] = true;
        System.out.print(v+ " ");

        for(int i = 1; i<data.length; i++){
            //연결은 되어있는데, 방문하지 않았다면 재귀 돌리기
            if(data[v][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    private static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visited[v] = true;
        System.out.print(v+" ");

        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i = 1 ;i<data.length; i++){
                if(data[tmp][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    System.out.print(i+" ");
                }
            }
        }
    }
}