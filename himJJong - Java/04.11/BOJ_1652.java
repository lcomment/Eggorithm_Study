import java.io.*;
import java.util.*;

public class BOJ_1652 {
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static char[][] data;
    static boolean[][] visited;
    static List<Node> list = new ArrayList<>();
    static List<Node> visitedList = new ArrayList<>();  // 하나만 있는 . 은 다시 false로 되돌리기 위함
    static StringBuilder sb = new StringBuilder();
    static int count = 0;   // row, col 공간 정답값
    static int checkCount = 0;  // 자리가 2 이상인지 체크하는 값
    static int[] dx = {1,-1};
    static int[] dy = {1,-1};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        data = new char[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            for(int j=0; j< tmp.length(); j++){
                data[i][j] = tmp.charAt(j);
                if(data[i][j]=='X') visited[i][j] = true;
            }
        }

        calRowBfs();
        initVisited();
        calColBfs();

    }

    private static void calColBfs() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[j][i]){
                    visited[j][i] = true;
                    checkCount = 1;
                    list.add(new Node(j,i));
                    colBfs();
                    if(checkCount>=2) count++;
                }
                if(checkCount == 1 && data[j][i] == '.'){
                    visited[j][i] = false;
                    continue;
                }
                visitedList.clear();
            }
        }
        sb.append(count);
        System.out.print(sb);
    }

    private static void initVisited() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(data[i][j]=='.') visited[i][j] = false;
            }
        }
    }

    private static void calRowBfs() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    checkCount = 1;
                    list.add(new Node(i,j));
                    rowBfs();
                    if(checkCount>=2) count++;
                }
                if(checkCount == 1 && data[i][j] == '.'){
                    visited[i][j] = false;
                    continue;
                }
                visitedList.clear();
            }
        }
        sb.append(count).append(" ");
        count = 0;
    }

    private static void colBfs() {
        while(!list.isEmpty()){
            Node tmp = list.remove(0);
            visitedList.add(tmp);
            for(int i=0; i<2; i++){
                int move_x = tmp.x + dx[i];
                int move_y = tmp.y;

                if(isArea(move_x,move_y)){
                    visited[move_x][move_y] = true;
                    Node addList = new Node(move_x,move_y);
                    list.add(addList);
                    visitedList.add(addList);
                    checkCount++;
                }
            }
        }
    }

    private static boolean isArea(int move_x, int move_y) {
        return move_x >= 0 && move_x < N && move_y >= 0 && move_y < N && !visited[move_x][move_y];
    }

    private static void rowBfs() {
        while(!list.isEmpty()){
            Node tmp = list.remove(0);
            visitedList.add(tmp);
            for(int i=0; i<2; i++){
                int move_x = tmp.x;
                int move_y = tmp.y+dy[i];

                if(isArea(move_x,move_y)){
                    visited[move_x][move_y] = true;
                    Node addList = new Node(move_x,move_y);
                    list.add(addList);
                    visitedList.add(addList);
                    checkCount++;
                }
            }
        }
    }

}
