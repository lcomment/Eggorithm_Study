import java.io.*;
import java.util.*;

public class BOJ_15685 {
    //상하좌우
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] data = new boolean[101][101];
    static LinkedList<Integer> directionList;
    static int answer;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int dragonCount = Integer.parseInt(br.readLine());
        int x,y,d,g;

        for(int i=0; i<dragonCount; i++){
            st = new StringTokenizer(br.readLine());

            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());

            directionList = new LinkedList<>();
            directionList.add(d);
            curve(g);
            drawMap(x,y);
        }
        checkMap();
        System.out.println(answer);
    }
    private static void curve(int g) {
        for(int i = 0; i<g; i++){
            // 매번 현재 길이만큼 더해주면서, 뒤집은 후 +1씩 인덱스를 더해 directionList에 추가
            int size = directionList.size();
            for(int j=1; j <=size; j ++){ // g = 0 -> 1번 , g = 1 -> 2번, g = 2 -> 4번 ...
                directionList.add((directionList.get(size-j)+1)%4); // 다음 꺾이기 위함 커브
            }
        }
    }
    private static void drawMap(int x, int y) {
        int tmpX = x;
        int tmpY = y;
        data[x][y] = true;

        for (int d : directionList) {
            tmpX += dx[d];
            tmpY += dy[d];
            data[tmpX][tmpY] = true;
        }
    }
    private static void checkMap() {
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(data[i][j] && data[i][j+1] && data[i+1][j] && data[i+1][j+1])
                    answer++;
            }
        }
    }
}
