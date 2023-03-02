import java.io.*;
import java.util.*;

public class BOJ_2667_BFS {
    public static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int size;
    static int[][] data;
    static boolean[][] visited;
    static int[] move_x = {0,1,0,-1};
    static int[] move_y = {1,0,-1,0};
    static int building = 1;
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        visited = new boolean[size][size];

        data = new int[size][size];

        for(int i=0; i<size; i++){
            data[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(data[i][j]==1 && !visited[i][j]){
                    q.add(new Point(i,j));
                    visited[i][j] = true;   //추가된거
                    bfs();
                    building++;
                }
            }
        }
        List<Integer> answer = new LinkedList<>();
        for(int i=0; i<building-1; i++){
            int count = 0;
            for(int j=0; j<size; j++){
                for(int k=0; k<size; k++){
                    if(data[j][k]==i+1){
                        count++;
                    }
                }
            }
            answer.add(count);
        }
        Collections.sort(answer);
        System.out.println(answer.size());

        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }

    }
    private static void bfs(){
        while(!q.isEmpty()){
            Point val = q.poll();
            int x = val.x;
            int y = val.y;

            //visted[x][y] = true;    삭제
            data[x][y] = building;

            for(int i=0; i<4; i++){
                int tmp_x = x+move_x[i];
                int tmp_y = y+move_y[i];

                if(check(tmp_x,tmp_y) && !visited[tmp_x][tmp_y] && data[tmp_x][tmp_y]==1){
                    visited[tmp_x][tmp_y] = true;   //추가된거
                    q.add(new Point(tmp_x,tmp_y));
                }
            }
        }
    }
    private static boolean check(int tmp_x, int tmp_y) {
        if(tmp_x >=0 && tmp_x<size && tmp_y>=0 && tmp_y<size) return true;
        else return false;
    }
}
