import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16724{
    static int N;
    static int M;
    static String[][] map;
    static boolean[][] visited;
    static boolean[][] fin;
    static int count = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new String[N][M];
        fin = new boolean[N][M];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().split("");
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        int moveX = x;
        int moveY = y;


        if(map[x][y].equals("D")){
            moveX++;
        }
        else if(map[x][y].equals("R")){
            moveY++;
        }
        else if(map[x][y].equals("L")){
            moveY--;
        }
        else if(map[x][y].equals("U")){
            moveX--;
        }

        if(!visited[moveX][moveY]){
            dfs(moveX, moveY);
        }
        else{
            if(!fin[moveX][moveY]){
                count++;
            }
        }
        fin[x][y] = true;
    }
}