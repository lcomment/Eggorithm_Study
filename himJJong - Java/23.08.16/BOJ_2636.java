import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2636 {
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
    static int time = 0;
    static boolean[][] visited;
    static int[][] map;
    static int[][] copy;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new int[N][M];
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int check = memoryCheeze();
        while(true){
            time++;
            edgeCheck(0,0);
            for(int i=0; i<N; i++){
                Arrays.fill(visited[i], false);
            }
            int checkCheeze = memoryCheeze();

            if(checkCheeze == 0)    break;
            else list.add(checkCheeze);
        }

        System.out.println(time);

        if(list.size() > 0) System.out.println(list.get(list.size()-1));
        else System.out.println(check);
    }

    private static void makeMap() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] > 1)   {
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void edgeCheck(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Node(x,y));
        while(!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int moveX = tmp.x + dx[i];
                int moveY = tmp.y + dy[i];

                if(moveX < 0 || moveX >=N || moveY < 0 || moveY >=M || visited[moveX][moveY]) continue;

                if(map[moveX][moveY] == 0){
                    visited[moveX][moveY] = true;
                    q.add(new Node(moveX,moveY));
                }
                else if(map[moveX][moveY] >= 1) {
                    map[moveX][moveY] = time+1;
                }
            }
        }
        makeMap();
    }


    private static int memoryCheeze() {
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1)  count++;
            }
        }
        return count;
    }
}
