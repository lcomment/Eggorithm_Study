import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_14502 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int max = Integer.MIN_VALUE;
    static int[][] data;
    static List<Node> list = new ArrayList<>();
    static List<Node> virusLocationList = new ArrayList<>();
    static int[] NM;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int[][] remember;
    static boolean[][] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        data = new int[NM[0]][NM[1]];
        remember = new int[NM[0]][NM[1]];
        visited = new boolean[NM[0]][NM[1]];

        for(int i=0; i<NM[0]; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(data[i][j] == 0) {
                    list.add(new Node(i,j));
                    visited[i][j] = true;
                    backTracking();
                    list.remove(0);
                }
            }
        }
        System.out.println(max);
    }

    private static void backTracking() {
        if(list.size()==3){
            configureWall();                // 벽을 3개 세웠을때
            rememberInit();
            checkVirusLocation();        // 해당 위치의 바이러스르를 체크 후
            bfsVirus();                  // 바이러스를 채우고
            max = Math.max(max,checkSafeZone());     // 바이러스 채운 배열의 안전구역 체크
            dataInit();
            breakWall();
            return;
        }

        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(!visited[i][j] && data[i][j] == 0){
                    visited[i][j] = true;
                    list.add(new Node(i,j));
                    backTracking();
                    visited[i][j] = false;
                    list.remove(list.size()-1);
                }
            }
        }

    }

    private static void dataInit() {
        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                data[i][j] = remember[i][j];
            }
        }
    }

    private static void rememberInit() {
        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                remember[i][j] = data[i][j];
            }
        }
    }

    private static void breakWall() {
        data[list.get(0).x][list.get(0).y] = 0;
        data[list.get(1).x][list.get(1).y] = 0;
        data[list.get(2).x][list.get(2).y] = 0;
    }

    private static void configureWall() {
        data[list.get(0).x][list.get(0).y] = 1;
        data[list.get(1).x][list.get(1).y] = 1;
        data[list.get(2).x][list.get(2).y] = 1;
    }

    private static void checkVirusLocation() {      // virus 위치 static list에 넣기
        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(data[i][j] == 2){
                    virusLocationList.add(new Node(i,j));
                }
            }
        }
    }

    private static int checkSafeZone() {    // 0인 sate구역 리턴
        int count = 0;

        for(int i=0; i<NM[0]; i++){
            for(int j=0; j<NM[1]; j++){
                if(data[i][j] == 0) count++;
            }
        }
        return count;
    }

    private static void bfsVirus() {
        while(!virusLocationList.isEmpty()){
            Node current = virusLocationList.remove(0);
            for(int i=0; i<4; i++){
                int move_x = current.x + dx[i];
                int move_y = current.y + dy[i];
                if(inArea(move_x,move_y) && data[move_x][move_y] == 0){
                    data[move_x][move_y] = 2;
                    virusLocationList.add(new Node(move_x,move_y));
                }
            }
        }

    }

    private static boolean inArea(int x, int y) {
        if(x >= 0 && y >=0 && x < NM[0] && y < NM[1]){
            return true;
        }
        return false;
    }
}
