import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_18428 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static String[][] data;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static List<Node> list = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        data = new String[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                data[i][j] = tmp[j];
                if(data[i][j].equals("T"))  list.add(new Node(i,j));
            }
        }

        backTracking(0,0,0);
        System.out.println("NO");
    }

    private static void backTracking(int depth,int x, int y) {
        if(depth == 3){
            if(check()){
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for(int i=x; i<N ; i++){
            for(int j=y; j<N; j++){
                if(data[i][j].equals("X") && !visited[i][j]){
                    visited[i][j] = true;
                    data[i][j] = "O";
                    backTracking(depth+1,i,j+1);
                    visited[i][j] = false;
                    data[i][j] = "X";
                }
            }
            y=0;
        }
    }

    private static boolean check() {
        for(int i=0; i<list.size(); i++){
            Node tmp = list.get(i);

            for(int j=0; j<4; j++){
                int moveX = tmp.x + dx[j];
                int moveY = tmp.y + dy[j];

                while (true){
                    if(moveX < 0 || moveY < 0 || moveX >= N || moveY >= N)  break;

                    if(data[moveX][moveY].equals("X") || data[moveX][moveY].equals("T")){
                        moveX += dx[j];
                        moveY += dy[j];
                    }
                    else if(data[moveX][moveY].equals("O")){
                        break;
                    }
                    else if(data[moveX][moveY].equals("S")){
                        return false;
                    }
                }

            }
        }
        return true;
    }
}
