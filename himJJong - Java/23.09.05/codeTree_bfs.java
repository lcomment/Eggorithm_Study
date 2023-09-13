import java.io.*;
import java.util.*;

public class codeTree_bfs {
    static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,-1,1,-1,1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        String[] tmp = br.readLine().split(" ");
        bfs(Integer.parseInt(tmp[0])-1,Integer.parseInt(tmp[1])-1);

        int[][] answer = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j])   answer[i][j] = 1;
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<8; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;

                if(isValid(moveX, moveY) && !visited[moveX][moveY] && map[moveX][moveY]==0){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
            }
        }
    }

    private static boolean isValid(int x, int y){
        if(x < 0 || x>=N || y <0 || y>=N || visited[x][y] || map[x][y]==1)  return false;
        return true;
    }

}