import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2573 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }
    static boolean[][] visited;
    static int count = 0;
    static int N;
    static int M;
    static int answer = 0;
    static int[][] data;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        while(true){
            count++;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(data[i][j] != 0) visited[i][j] = true;
                    else visited[i][j] = false;
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(data[i][j]==0 && !visited[i][j]){
                        check(i,j);
                    }
                }
            }

            int[][] tmp = new int[N][M];

            for(int i=0; i<N; i++){
                tmp[i] = Arrays.copyOfRange(data[i],0,M);
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(tmp[i][j] != 0) {
                        bfs(i, j, tmp);
                        answer++;
                    }
                }
            }
            if(answer >= 2){
                System.out.println(count);
                break;
            }
            answer = 0;

            if(checkAll()){
                System.out.println(0);
                break;
            }
        }

    }

    private static void bfs(int x, int y, int[][] tmp) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));

        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i=0; i<4; i++){
                int moveX = cur.x + dx[i];
                int moveY = cur.y + dy[i];

                if(moveX >=0 && moveY >=0 && moveX <N && moveY <M && tmp[moveX][moveY] !=0){
                    tmp[moveX][moveY] = 0;
                    q.add(new Node(moveX,moveY));
                }
            }
        }
    }

    private static boolean checkAll() {
        for(int i=0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(data[i][j] !=0)  return false;
            }
        }
        return true;
    }

    private static void check(int x, int y) {
        for(int i=0; i<4; i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= M || data[moveX][moveY] == 0){
                continue;
            }
            data[moveX][moveY]--;
        }

    }


}
