import java.util.*;
import java.io.*;

public class BOJ_14503 {
    static int N, M;
    static int answer = 1;
    static int[][] data;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data =  new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        dfs(x,y,direction);
        System.out.println(answer);
    }

    private static void dfs(int x,int y,int see) {
        data[x][y] = 2;            // 청소 구역은 2로

        for(int i=0; i<4; i++){
            see -= 1;              // 왼쪽방향으로 탐색
            if(see == -1) see = 3;

            int move_x = x + dx[see];
            int move_y = y + dy[see];
            if(move_x > 0 && move_y >0 && move_x < N && move_y < M){
                if(data[move_x][move_y] == 0){
                    answer++;
                    dfs(move_x, move_y, see);
                    // 일반적인 dfs는 가다가 길이 막히면 다시 되돌아와서 해당 위치부터 계산하지만,
                    // 후진할 때만 이전 길을 되돌가 가며
                    // 확인할 수 있으므로 return을 해서 다시 되돌아 와도 더 이상 움직이면 안된다
                    return;
                }
            }
        }
        //반목문을 빠져 나왔단는 것은 주변에 더 이상 청소할 공간이 없다는 의미이다.
        int d = (see + 2) % 4;  //반대 방향으로 후진하기 위함.
        int back_x = x + dx[d];
        int back_y = y + dy[d];
        if(back_x > 0 && back_y > 0 && back_x < N && back_y < M && data[back_x][back_y] != 1) {
            dfs(back_x, back_y, see); //후진할 때 방향을 유지해야 한다.
        }
    }
}