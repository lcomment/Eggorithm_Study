import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Pair> q = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] data = new int[N][M];
        int[][] check = new int[N][M];

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int i =0; i<N; i++){
            int[] row = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(row, 0, data[i], 0, M);
            Arrays.fill(check[i],-1);
        }

        q.offer(new Pair(0,0)); //시작
        check[0][0] = 0;

        while(!q.isEmpty()){
            Pair val = q.poll();

            for(int i=0; i<4; i++){
                int tmpX = val.getX() + dx[i];
                int tmpY = val.getY() + dy[i];

                //범위 벗어나거나 Pass
                if(tmpX <0  || tmpX >= N || tmpY<0 || tmpY >=M){
                    continue;
                }

                //벽이거나, 방문했다면 Pass
                if(data[tmpX][tmpY] == 0 || check[tmpX][tmpY] !=-1){
                    continue;
                }

                q.offer(new Pair(tmpX,tmpY));
                check[tmpX][tmpY] = check[val.getX()][val.getY()]+1;
            }
        }
        System.out.println(check[N-1][M-1]+1);
    }
    static class Pair{
        private int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}