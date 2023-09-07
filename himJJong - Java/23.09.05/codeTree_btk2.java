import java.io.*;
import java.util.*;

public class codeTree_btk2 {
    static int[] answer;
    static int max = Integer.MIN_VALUE;
    static int count;
    static int[][] map;
    static int N;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] dx2 = {1,1,-1,-1};
    static int[] dy2 = {1,-1,1,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1){
                    count++;
                }
            }
        }

        answer = new int[count];
        backTracking(0);
        System.out.println(max + count);
    }

    private static void backTracking(int num){
        if(num == count){
            int result = cal();
            max = Math.max(max, result);
            return;
        }

        for(int i=1; i<=3; i++){
            answer[num] = i;
            backTracking(num+1);
        }
    }

    private static int cal(){
        int result = 0;
        boolean[][] visited = new boolean[N][N];
        int index = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1){
                    if(answer[index] == 1){
                        int up1 = i+1;
                        int up2 = i+2;
                        int down1 = i-1;
                        int down2 = i-2;

                        if(up1 < N){
                            visited[up1][j] = true;
                        }
                        if(up2 < N){
                            visited[up2][j] = true;
                        }
                        if(down1 >= 0){
                            visited[down1][j] = true;
                        }
                        if(down2 >= 0){
                            visited[down2][j] = true;
                        }
                    }
                    else if(answer[index] == 2){
                        for(int k=0;k<4; k++){
                            int moveX = i + dx[k];
                            int moveY = j + dy[k];

                            if(moveX >=0 && moveX <N && moveY >=0 && moveY < N){
                                visited[moveX][moveY] = true;
                            }
                        }
                    }
                    else if(answer[index] == 3){
                        for(int k=0;k<4; k++){
                            int moveX = i + dx2[k];
                            int moveY = j + dy2[k];

                            if(moveX >=0 && moveX <N && moveY >=0 && moveY < N){
                                visited[moveX][moveY] = true;
                            }
                        }
                    }
                    index++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j] && map[i][j] == 0){
                    result++;
                }
            }
        }
        return result;
    }
}