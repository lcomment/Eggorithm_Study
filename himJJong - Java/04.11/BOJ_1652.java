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
    static List<Node> visitedList = new ArrayList<>();
    static int count = 0;
    static int checkCount = 0;
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

        boolean[][] col = visited.clone();


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    checkCount = 1;
                    list.add(new Node(i,j));
                    bfs();
                    if(checkCount>=2) count++;
                }
                if(checkCount == 1 && data[i][j] == '.'){
                    visited[i][j] = false;
                    continue;
                }
                visitedList.clear();
            }
        }
        System.out.print(count+" ");
        count = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(data[i][j]=='.') visited[i][j] = false;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[j][i]){
                    visited[j][i] = true;
                    checkCount = 1;
                    list.add(new Node(j,i));
                    bfs2();
                    if(checkCount>=2) count++;
                }
                if(checkCount == 1 && data[j][i] == '.'){
                    visited[j][i] = false;
                    continue;
                }
                visitedList.clear();
            }
        }
        System.out.print(count+" ");
    }

    private static void bfs2() {
        while(!list.isEmpty()){
            Node tmp = list.remove(0);
            visitedList.add(tmp);
            for(int i=0; i<2; i++){
                int move_x = tmp.x + dx[i];
                int move_y = tmp.y;

                if(move_x>=0 && move_x <N && move_y >=0 && move_y <N && !visited[move_x][move_y]){
                    visited[move_x][move_y] = true;
                    Node addList = new Node(move_x,move_y);
                    list.add(addList);
                    visitedList.add(addList);
                    checkCount++;
                }
            }
        }
    }

    private static void bfs() {
        while(!list.isEmpty()){
            Node tmp = list.remove(0);
            visitedList.add(tmp);
            for(int i=0; i<2; i++){
                int move_x = tmp.x;
                int move_y = tmp.y+dy[i];

                if(move_x>=0 && move_x <N && move_y >=0 && move_y <N && !visited[move_x][move_y]){
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
