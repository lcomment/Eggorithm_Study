import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21611 {
    static int[][] map;
    static int[][] num;
    static int[][] magic;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] cnt = new int[3];
    static int sharkX;
    static int sharkY;
    static int N,M;
    static boolean flag = true;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        num = new int[N][N];
        magic = new int[M][2];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            magic[i][0] = Integer.parseInt(st.nextToken());
            magic[i][1] = Integer.parseInt(st.nextToken());
        }

        sharkX = (N+1)/2;
        sharkY = (N+1)/2;

        magicBreak();
        while(M-- >0){
            blankConnect(); // 댕기기
            checkConnect(); // 4개 이상 붙어있는거 폭파
            split();    // 그룹함수 변환
        }
    }

    private static void split() {
    }

    private static void blankConnect() {

    }

    private static void checkConnect() {
        // 4개연속 붙어있으면 count++;
        int count = 0;

        //처음부터 순차적으로 확인하면 되고



        if(count == 0){ // 4개 붙어있는게 없다면 나오기
            flag = false;
        }
    }

    private static void magicBreak() {
        for(int i=0; i<M; i++){
            int moveX = sharkX;
            int moveY = sharkY;
            for(int j=0; j<magic[i][1]; j++){
                moveX += dx[magic[i][0]];
                moveY += dy[magic[i][0]];
                if(inRange(moveX,moveY)){
                    map[moveX][moveY] = 0;
                }
                else{
                    break;
                }
            }
        }
    }

    private static boolean inRange(int moveX, int moveY) {
        return moveX >= 0 && moveX < N && moveY >= 0 && moveY < M;
    }
}
