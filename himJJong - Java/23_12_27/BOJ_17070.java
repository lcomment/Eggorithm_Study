import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17070 {
    static int N;
    static int[][] map;
    static int[] dx = {0,1,1};
    static int[] dy = {1,1,0};
    static int count = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        dfs(0, 1, 0);

        System.out.println(count);
    }

    private static void dfs(int x, int y, int spin) {
        if(x == N-1 && y == N-1){
            count++;
            return;
        }

        for(int i=0; i<3; i++){
            if(inArea(x+dx[i], y+dy[i]) && checkDir(spin,i) && isWall(i,x+dx[i],y+dy[i])){  // 벽 체크, 밖으로 나가는 것 체크, 90" 체크
                dfs(x+dx[i], y+dy[i],i);
            }
        }
    }

    private static boolean checkDir(int momorySpin, int curSpin) {
        if(momorySpin == 0 && curSpin == 2) return false;
        else if(momorySpin == 2 && curSpin == 0)    return false;
        return true;
    }

    private static boolean isWall(int index, int x, int y) {
        if(index == 0){ // 수평 오른쪽 직선 이동
            if(map[x][y] == 1){
                return false;
            }
        }
        else if(index == 1){ // 수직 아래 직선 이동
            if(x-1 >= N || y-1 <0)  return false;
            if(map[x][y] == 1 || map[x-1][y] == 1 || map[x][y-1] == 1){
                return false;
            }
        }
        if(index == 2){ // 수직 아래 이동
            if(map[x][y] == 1){
                return false;
            }
        }
        return true;
    }

    private static boolean inArea(int x, int y) {
        if((x>=0 && x<N) && (y>=0 && y<N))  return true;
        return false;
    }
}
