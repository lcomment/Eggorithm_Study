import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17144 {
    static int[][] map;
    static int[][] cal;
    static int row;
    static int col;
    static int index = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int answer = 0;

        map = new int[row][col];
        cal = new int[row][col];

        for(int i=0; i<row; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        findAircondition();
        for(int i=0; i<T; i++){
            spreadDust();
            calCulate();
            cleanUp();
            cleanDown();
        }
        answer = countDust();
        System.out.println(answer);
    }

    private static void findAircondition() {
        Loop:
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] == -1) {
                    index=i;
                    break Loop;
                }
            }
        }
    }

    private static void calCulate() {
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                map[i][j] = cal[i][j];
            }
        }
        map[index][0] = -1;
        map[index+1][0] = -1;

        for(int i=0; i<row; i++){
            Arrays.fill(cal[i],0);
        }
    }

    private static int countDust() {
        int count = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(map[i][j] > 0)   count += map[i][j];
            }
        }

        return count;
    }

    private static void cleanDown() {
        int x = index+1;
        int memory = 0;

        for(int i=1; i<col; i++){
            if(map[x][i] == 0 && memory == 0){
                continue;
            }
            else if(map[x][i] == 0 && memory != 0){
                map[x][i] = memory;
                memory = 0;
            }
            else if(map[x][i] != 0 && memory == 0){
                memory = map[x][i];
                map[x][i] = 0;
            }
            else if(map[x][i] != 0 && memory != 0 ){
                int tmp = map[x][i];
                map[x][i] = memory;
                memory = tmp;
            }
        }

        for(int i=x+1; i<row; i++){
            if(map[i][col-1] == 0 && memory == 0){
                continue;
            }
            else if(map[i][col-1] == 0 && memory != 0){
                map[i][col-1] = memory;
                memory = 0;
            }
            else if(map[i][col-1] != 0 && memory == 0){
                memory = map[i][col-1];
                map[i][col-1] = 0;
            }
            else if(map[i][col-1] != 0 && memory != 0 ){
                int tmp = map[i][col-1];
                map[i][col-1] = memory;
                memory = tmp;
            }
        }

        for(int i=col-2; i>=0; i--){
            if(map[row-1][i] == 0 && memory == 0){
                continue;
            }
            else if(map[row-1][i] == 0 && memory != 0){
                map[row-1][i] = memory;
                memory = 0;
            }
            else if(map[row-1][i] != 0 && memory == 0){
                memory = map[row-1][i];
                map[row-1][i] = 0;
            }
            else if(map[row-1][i] != 0 && memory != 0 ){
                int tmp = map[row-1][i];
                map[row-1][i] = memory;
                memory = tmp;
            }
        }

        for(int i=row-2; i>=x; i--){
            if(map[i][0] == -1)    continue;
            if(map[i][0] == 0 && memory == 0){
                continue;
            }
            else if(map[i][0] == 0 && memory != 0){
                map[i][0] = memory;
                memory = 0;
            }
            else if(map[i][0] != 0 && memory == 0){
                memory = map[i][0];
                map[i][0] = 0;
            }
            else if(map[i][0] != 0 && memory != 0 ){
                int tmp = map[i][0];
                map[i][0] = memory;
                memory = tmp;
            }
        }
    }

    private static void cleanUp() {
        int x = index;
        int memory = 0;

        for(int i=1; i<col; i++){
            if(map[x][i] == 0 && memory == 0){
                continue;
            }
            else if(map[x][i] == 0 && memory != 0){
                map[x][i] = memory;
                memory = 0;
            }
            else if(map[x][i] != 0 && memory == 0){
                memory = map[x][i];
                map[x][i] = 0;
            }
            else if(map[x][i] != 0 && memory != 0 ){
                int tmp = map[x][i];
                map[x][i] = memory;
                memory = tmp;
            }
        }

        for(int i=x-1; i>=0; i--){
            if(map[i][col-1] == 0 && memory == 0){
                continue;
            }
            else if(map[i][col-1] == 0 && memory != 0){
                map[i][col-1] = memory;
                memory = 0;
            }
            else if(map[i][col-1] != 0 && memory == 0){
                memory = map[x][i];
                map[i][col-1] = 0;
            }
            else if(map[i][col-1] != 0 && memory != 0 ){
                int tmp = map[i][col-1];
                map[i][col-1] = memory;
                memory = tmp;
            }
        }
        for(int i=col-2; i>=0; i--){
            if(map[0][i] == 0 && memory == 0){
                continue;
            }
            else if(map[0][i] == 0 && memory != 0){
                map[0][i] = memory;
                memory = 0;
            }
            else if(map[0][i] != 0 && memory == 0){
                memory = map[0][i];
                map[0][i] = 0;
            }
            else if(map[0][i] != 0 && memory != 0 ){
                int tmp = map[0][i];
                map[0][i] = memory;
                memory = tmp;
            }
        }

        for(int i=1; i<=x; i++){
            if(map[i][0] == -1)    continue;
            if(map[i][0] == 0 && memory == 0){
                continue;
            }
            else if(map[i][0] == 0 && memory != 0){
                map[i][0] = memory;
                memory = 0;
            }
            else if(map[i][0] != 0 && memory == 0){
                memory = map[i][0];
                map[i][0] = 0;
            }
            else if(map[i][0] != 0 && memory != 0 ){
                int tmp = map[i][0];
                map[i][0] = memory;
                memory = tmp;
            }
        }
    }

    private static void spreadDust() {
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                int cur = map[i][j];
                int count  = 0;
                int spread = map[i][j] / 5;
                if(cur <= 0)    continue;
                for(int k=0; k<4; k++){
                    int moveX = dx[k] + i;
                    int moveY = dy[k] + j;

                    if(moveX < 0 || moveX >= row || moveY < 0 || moveY >= col || map[moveX][moveY] == -1)   continue;
                    if(spread != 0 ) {
                        count++;
                        cal[moveX][moveY] += spread;
                    }
                }
                cal[i][j] += map[i][j] - (spread*count);
            }
        }
    }
}
