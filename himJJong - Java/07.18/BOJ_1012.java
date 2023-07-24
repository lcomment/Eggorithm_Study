import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1012 {
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T -- >0){
             st = new StringTokenizer(br.readLine());

             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
             int answer = 0;

             int count = Integer.parseInt(st.nextToken());

             if(count==1){
                 sb.append(1).append("\n");
                 continue;
             }
             map = new int[N][M];
             visited = new boolean[N][M];

             for(int i=0; i<count; i++){
                 String[] tmp = br.readLine().split(" ");
                 map[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = 1;
             }

             for(int i=0; i<N; i++){
                 for(int j=0; j<M; j++){
                     if(map[i][j]==1 && !visited[i][j]){
                         answer++;
                         bfs(i,j);
                     }
                 }
             }


             sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;

                if(moveX >= 0 && moveX < N && moveY >=0 && moveY <M && map[moveX][moveY]==1 && !visited[moveX][moveY]){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
            }
        }
    }
}
