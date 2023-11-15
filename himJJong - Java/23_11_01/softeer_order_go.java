import java.io.*;
import java.util.*;

public class softeer_order_go {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Node[] dest;
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        dest = new Node[M];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            dest[i] = new Node(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())-1 );
        }
        visited[dest[0].x][dest[0].y] = true;
        dfs(dest[0].x, dest[0].y, 1);
        System.out.println(answer);
    }


    public static void dfs(int x, int y, int index){
        if(index == M){
            answer++;
            return;
        }

        for(int i=0; i<4 ; i++){
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;

            if(moveX < 0 || moveX >= N || moveY < 0 || moveY >=N || visited[moveX][moveY] || map[moveX][moveY] == 1)continue;
            int temp = 0;
            if(dest[index].x == moveX && dest[index].y == moveY){
                temp = 1;
            }
            visited[moveX][moveY] = true;
            dfs(moveX, moveY, index + temp);
            visited[moveX][moveY] = false;
        }
    }
}