import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static class Node{
        int x;
        int y;
        int chance;
        int dis;
        Node(int x,int y, int chance, int dis) {
            this.x = x;
            this.y = y;
            this.chance = chance;
            this.dis = dis;
        }
    }
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;
    static int[][] data;
    static boolean[][][] visited;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N==1 && M==1)   {
            System.out.println(1);
            System.exit(0);
        }

        data = new int[N][M];

        for(int i=0; i<N; i++){
            data[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        visited = new boolean[N][M][2];

        q.add(new Node(N-1,M-1,1,0));
        visited[0][0][0] = true;
        visited[0][0][1] = true;
        bfs();

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer+2);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int moveX = dx[i] + tmp.x;
                int moveY = dy[i] + tmp.y;
                if(moveX == 0 && moveY == 0){
                    answer = Math.min(tmp.dis, answer);
                    continue;
                }
                if(moveX >=0 && moveY >=0 && moveX <N && moveY<M && data[moveX][moveY] == 1  && tmp.chance == 0){
                    continue;
                }
                if(moveX >=0 && moveY >=0 && moveX <N && moveY<M && !visited[moveX][moveY][1] && data[moveX][moveY] == 1  && tmp.chance == 1){
                    visited[moveX][moveY][1] = true;
                    q.add(new Node(moveX,moveY, 0, tmp.dis+1));
                }

                else if(moveX >=0 && moveY >=0 && moveX <N && moveY<M && !visited[moveX][moveY][1] && data[moveX][moveY] == 0 && tmp.chance == 1) {
                    visited[moveX][moveY][1] = true;
                    q.add(new Node(moveX, moveY, tmp.chance, tmp.dis + 1));
                }

                else if(moveX >=0 && moveY >=0 && moveX <N && moveY<M && !visited[moveX][moveY][0] && data[moveX][moveY] == 0 && tmp.chance == 0) {
                    visited[moveX][moveY][0] = true;
                    q.add(new Node(moveX, moveY, tmp.chance, tmp.dis + 1));
                }
            }
        }
    }
}
