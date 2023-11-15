import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1261 {
    static class Node{
        int x;
        int y;
        int wall;
        Node(int x, int y,int wall){
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int N;
    static int M;
    static int answer;
    static int[][] map;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        map = new int[M][N];

        for(int i=0; i<M; i++){
            map[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        bfs(0,0);

        if(answer == Integer.MAX_VALUE){
            System.out.println(0);
        }
        else{
            System.out.println(answer);
        }
    }

    private static void bfs(int x, int y) {
        Deque<Node> dq = new LinkedList<>();
        dq.add(new Node(x,y,0));
        visited[x][y] = true;
        while(!dq.isEmpty()){
            Node tmp = dq.poll();
            for(int i=0; i<4; i++){
                int moveX = tmp.x + dx[i];
                int moveY = tmp.y + dy[i];
                if(moveX == M-1 && moveY == N-1) {
                    answer = tmp.wall;
                    break;
                }
                if(moveX <0 || moveX >=M || moveY <0 || moveY >=N || visited[moveX][moveY]){
                    continue;
                }
                if(map[moveX][moveY] == 0){
                    dq.addFirst(new Node(moveX,moveY,tmp.wall));
                    visited[moveX][moveY] = true;
                }

                else if(map[moveX][moveY] == 1){
                    dq.add(new Node(moveX, moveY, tmp.wall+1));
                    visited[moveX][moveY] = true;
                }
            }
        }
    }
}
