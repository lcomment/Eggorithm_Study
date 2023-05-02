import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15683{
    static class cctv{
        int num;
        int x;
        int y;
        cctv(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int M;
    static int[][] map;
    static int[] direction;
    static int[][] copyMap;
    static int min = Integer.MAX_VALUE;

    static int[] spinX = {-1,0,1,0};
    static int[] spinY = {0,1,0,-1};
    static List<cctv> cctvList = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) cctvList.add(new cctv(map[i][j],i,j));
            }
        }

        direction = new int[cctvList.size()];
        backTracking(0,cctvList.size());

        System.out.println(min);
    }

    private static void backTracking(int depth, int size) {
        if(depth == size){
            copyMap = new int[N][M];
            for(int i=0; i<N; i++){
                System.arraycopy(map[i],0,copyMap[i],0,map[i].length);
            }

            for(int i=0; i<cctvList.size();i++){
                directionCheck(cctvList.get(i),direction[i]);
            }

            check();
            return;
        }
        for(int i=0; i<4; i++){
            direction[depth] = i;
            backTracking(depth+1, size);
        }
    }

    private static void directionCheck(cctv data, int loc) {
        if(data.num == 1){
            if(loc == 0) bfs(data, 0);
            if(loc == 1) bfs(data, 1);
            if(loc == 2) bfs(data, 2);
            if(loc == 3) bfs(data, 3);
        }
        else if(data.num == 2){
            if(loc == 0 || loc == 2){
                bfs(data,0);
                bfs(data, 2);
            }
            else {
                bfs(data,1);
                bfs(data, 3);
            }
        }

        else if(data.num == 3){
            if(loc == 0){
                bfs(data,0);
                bfs(data,1);
            }
            else if(loc == 1){
                bfs(data,1);
                bfs(data,2);
            }
            else if(loc == 2){
                bfs(data,2);
                bfs(data,3);
            }
            else if(loc == 3){
                bfs(data,3);
                bfs(data,0);
            }
        }

        else if(data.num == 4){
            if(loc == 0){
                bfs(data,3);
                bfs(data,0);
                bfs(data,1);
            }
            else if(loc == 1){
                bfs(data,0);
                bfs(data,1);
                bfs(data,2);
            }
            else if(loc == 2){
                bfs(data,1);
                bfs(data,2);
                bfs(data,3);
            }
            else if(loc == 3){
                bfs(data,2);
                bfs(data,3);
                bfs(data,0);
            }
        }

        else if(data.num == 5){
            bfs(data,0);
            bfs(data,1);
            bfs(data,2);
            bfs(data,3);
        }
    }

    private static void bfs(cctv data, int i) {
        boolean[][] checkVisited = new boolean[N][M];
        checkVisited[data.x][data.y] = true;
        Queue<cctv> q = new LinkedList<>();
        q.add(data);
        while (!q.isEmpty()){
            cctv tmp = q.poll();
            int moveX = tmp.x+spinX[i];
            int moveY = tmp.y+spinY[i];

            if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= M || copyMap[moveX][moveY] == 6){
                break;
            }
            if(copyMap[moveX][moveY] == 0){
                copyMap[moveX][moveY] = 8;
                q.add(new cctv(tmp.num,moveX,moveY));
            }
            else{
                q.add(new cctv(tmp.num,moveX,moveY));
            }
        }
    }

    private static void check() {
        int result = 0;
        for(int i=0; i<N;i++){
            for(int j=0; j<M; j++){
                if(copyMap[i][j] == 0) result++;
            }
        }
        min = Math.min(min, result);
    }
}