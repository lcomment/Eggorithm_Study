import java.io.*;
import java.util.*;

public class BOJ_2667_DFS {
    static int size;
    static int[][] data;
    static boolean[][] visited;
    static int[] move_x = {0,1,0,-1};
    static int[] move_y = {1,0,-1,0};
    static int building = 1;
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
                    dfs(i,j);
                    building++;
                }
            }
        }

        int[] result = new int[building-1];

        for(int i=0; i<building; i++){
            for(int j=0; j<size; j++){
                for(int k=0; k<size; k++){
                    if(data[j][k]==i+1){
                        result[i]++;
                    }
                }
            }
        }
        Arrays.sort(result);
        System.out.println(building-1);
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        data[x][y] = building;
        for(int i=0; i<4; i++){
            int tmp_x = x+move_x[i];
            int tmp_y = y+move_y[i];
            
            if(check(tmp_x,tmp_y) && !visited[tmp_x][tmp_y] && data[tmp_x][tmp_y]==1){
                dfs(tmp_x,tmp_y);
            }
        }
    }
    private static boolean check(int tmp_x, int tmp_y) {
        if(tmp_x >=0 && tmp_x<size && tmp_y>=0 && tmp_y<size) return true;
        else return false;
    }
}
