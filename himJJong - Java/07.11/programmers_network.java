import java.util.LinkedList;
import java.util.Queue;

public class programmers_network {
    static boolean[] visited;
    static int size;
    public static void main(String[] args) {
        int n = 4;
        size = n;
        int[][] computers = {{1,1,0,1},{1,1,0,0},{0,0,1,1},{1,0,1,1}};

        int answer = 0;
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                bfs(i,computers);
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int index, int[][] computers) {
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i=0; i<size; i++){
                if(computers[cur][i] ==1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
