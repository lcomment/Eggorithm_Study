import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18809 {
    static class Node{
        int x;
        int y;
        int time;
        Node(int x, int y){
            this.x = x;
            this.y = y;
            this.time = 0;
        }
    }
    static class Pos{
        int time;
        int type;

        public Pos() {
        }
        Pos(int time, int type){
            this.time = time;
            this.type = type;
        }
    }
    static int N, M, green, red;
    static int max = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[] visited;
    static int[] greens, reds;
    static List<Node> possible = new ArrayList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static final int GREEN = 3;
    static final int RED = 4;
    static final int FLOWER = 5;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        green = Integer.parseInt(st.nextToken());
        red = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
                if(map[i][j] == 2){
                    possible.add(new Node(i,j));
                }
            }
        }

        greens = new int[green];
        reds = new int[red];
        visited = new boolean[10];

        selectGreen(0,0);
        System.out.println(max);
    }

    private static void selectGreen(int start, int count) {
        if(count == green){
            selectRed(0,0);
            return;
        }

        for(int i=start; i< possible.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                greens[count] = i;
                selectGreen(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    private static void selectRed(int start, int count) {
        if(count == red){
            bfs();
            return;
        }

        for(int i=start; i< possible.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                reds[count] = i;
                selectRed(i+1, count+1);
                visited[i] = false;
            }
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        Pos[][] state = new Pos[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                state[i][j] = new Pos();
            }
        }

        for(int i=0; i<green; i++){
            Node tmp = possible.get(greens[i]);
            state[tmp.x][tmp.y] = new Pos(0,GREEN);
            q.add(new Node(tmp.x, tmp.y));
        }

        for(int i=0; i<red; i++){
            Node tmp = possible.get(reds[i]);
            state[tmp.x][tmp.y] = new Pos(0, RED);
            q.add(new Node(tmp.x, tmp.y));
        }

        int sum  =0;
        while(!q.isEmpty()){
            Node tmp = q.poll();
            int curtime = state[tmp.x][tmp.y].time;
            int curtype = state[tmp.x][tmp.y].type;

            if(state[tmp.x][tmp.y].type == FLOWER)   continue;
            for(int i=0; i<4; i++){
                int moveX = tmp.x + dx[i];
                int moveY = tmp.y + dy[i];

                if(isValid(moveX,moveY) && map[moveX][moveY] !=0){
                    if(state[moveX][moveY].type == GREEN){
                        if(curtype == RED && state[moveX][moveY].time == curtime+1){
                            sum++;
                            state[moveX][moveY].type = FLOWER;
                        }
                    }
                    else if(state[moveX][moveY].type == RED){
                        if(curtype == GREEN && state[moveX][moveY].time == curtime+1){
                            sum++;
                            state[moveX][moveY].type = FLOWER;
                        }
                    }
                    else if(state[moveX][moveY].type == 0){
                        state[moveX][moveY] = new Pos(curtime+1, curtype);
                        q.add(new Node(moveX,moveY));
                    }
                }
            }
        }
        max = Math.max(max, sum);
    }

    private static boolean isValid(int moveX, int moveY) {
        if(moveX <0 || moveX>=N ||moveY <0 || moveY>=M) return false;
        return true;
    }
}