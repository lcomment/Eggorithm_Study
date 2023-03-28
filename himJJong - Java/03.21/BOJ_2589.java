import java.util.*;
import java.io.*;

public class BOJ_2589 {
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int x, int y,int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[] NM;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static String[][] board;
    static List<Node> q = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        NM  = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        board = new String[NM[0]][NM[1]];
        for(int i=0;i<NM[0];i++){
            String[] tmp = br.readLine().split("");
            for(int j=0; j<NM[1]; j++){
                board[i][j] = tmp[j];
            }
        }

        for(int i=0; i<NM[0];i++){
            for(int j=0; j<NM[1]; j++){
                if(board[i][j].equals("L"))   {
                    visited = new boolean[NM[0]][NM[1]];
                    int len = bfs(new Node(i,j,0));
                    max = Math.max(len,max);
                }
            }
        }
        System.out.println(max);
    }

    private static int bfs(Node node) {
        q.add(node);
        visited[node.x][node.y] = true;
        int len = 0;
        while(!q.isEmpty()){
            Node tmp = q.remove(0);
            for(int i=0; i<4; i++){
                int moveX = tmp.x + dx[i];
                int moveY = tmp.y + dy[i];

                if(moveX>=0 && moveX <NM[0] && moveY>=0 && moveY <NM[1] && !visited[moveX][moveY] && board[moveX][moveY].equals("L")){
                    visited[moveX][moveY] = true;
                    len = Math.max(len,tmp.cnt+1);
                    q.add(new Node(moveX,moveY,tmp.cnt+1));
                }
            }
        }
        return len;
    }
}