import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14620 {
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static Node[] flower;
    static boolean[][] visited;
    static int[][] map;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        flower = new Node[3];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        backTracking(0);
        System.out.println(min);
    }

    private static void backTracking(int depth) {
        if (depth == 3) {
            calculate();
            return;
        }
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                Node tmp = new Node(i,j);
                if(check(tmp)){
                    flower[depth] = tmp;
                    backTracking(depth+1);
                    init(flower[depth]);
                }
            }
        }
    }

    private static void init(Node node) {
        visited[node.x][node.y] = false;
        for(int i=0; i<4; i++){
            int moveX = dx[i] + node.x;
            int movey = dy[i] + node.y;

            visited[moveX][movey] = false;
        }
    }

    private static boolean check(Node tmp) {
        int count = 0;
        boolean[][] copyMap = new boolean[N][N];

        for(int i=0; i<N; i++){
            System.arraycopy(visited[i],0,copyMap[i],0,visited[i].length);
        }

        for(int i=0;i<4; i++){
            int mpveX = dx[i] + tmp.x;
            int mpveY = dy[i] + tmp.y;

            if(!copyMap[mpveX][mpveY])  count++;
        }

        if(count==4) {
            visited[tmp.x][tmp.y] = true;
            for(int i=0;i<4; i++){
                int mpveX = dx[i] + tmp.x;
                int mpveY = dy[i] + tmp.y;

                visited[mpveX][mpveY] = true;
            }
            return true;
        }
        else return false;
    }

    private static void calculate() {
        int result = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<N ; j++){
                if(visited[i][j])    result+=map[i][j];
            }
        }
        min = Math.min(result,min);
    }
}