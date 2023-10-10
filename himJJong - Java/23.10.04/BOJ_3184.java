import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3184 {
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
    static String[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int wolves = 0;
    static int sheep = 0;
    static int answerWolves = 0;
    static int answerSheep = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<tmp.length; j++){
                map[i][j] = tmp[j];
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!map[i][j].equals("#") && !visited[i][j]){
                    bfs(i,j);
                    if(sheep > wolves){
                        answerSheep += sheep;
                    }
                    else{
                        answerWolves += wolves;
                    }
                    sheep = 0;
                    wolves = 0;
                }
            }
        }

        System.out.print(answerSheep+" "+answerWolves);
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        if(map[x][y].equals("o"))   sheep++;
        else if(map[x][y].equals("v"))  wolves++;
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;
                if(moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && !visited[moveX][moveY] && !map[moveX][moveY].equals("#")){
                    if(map[moveX][moveY].equals("o"))   sheep++;
                    else if(map[moveX][moveY].equals("v"))   wolves++;
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
            }
        }
    }
}
