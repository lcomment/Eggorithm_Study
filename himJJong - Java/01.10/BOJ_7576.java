import java.io.*;
import java.util.*;

public class BOJ_7576 {

    static int row;
    static int col;
    static int[][] data;
    static int maxVal;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> q = new LinkedList<>();

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        data = new int[col][row];

        for(int i = 0; i< col; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< row; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if(data[i][j]==1) q.add(new int[] {i,j});
            }
        }


        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                //범위 밖으로 벗어나면 continue
                if(nextX < 0 || nextY < 0 || nextX >= col  || nextY >= row)
                    continue;

                //토마토가 없거나, 익은 토마토라면 continue
                if(data[nextX][nextY] != 0)
                    continue;

                //위 조건들을 만족하지 않는다면 다음 칸 갱신 후 큐에 다음 칸 인덱스 추가
                data[nextX][nextY] = data[nowX][nowY] + 1;
                q.add(new int[] {nextX, nextY});
            }
        }

        //check가 끝난 토마토밭을 돌면서 0이 있는지, 없다면 maxVal은 몇인지 체크
        for(int i = 0; i< col; i++) {
            for(int j = 0; j< row; j++) {
                if(data[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                maxVal = Math.max(maxVal, data[i][j]);
            }
        }
        System.out.println(maxVal-1);
    }
}