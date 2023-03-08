import java.io.*;
import java.util.*;

public class BOJ_2468 {
    static int size;
    static int answer = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[][] data;
    static boolean[][] check;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        data = new int[size][size];

        for(int i=0; i<size; i++) {
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < size; j++) {
                min = Math.min(data[i][j], min);
                max = Math.max(data[i][j], max);
            }
        }

        for(int i=min; i<=max ; i++){
            int count = 0;
            check = new boolean[size][size];
            for(int j=0; j<size; j++){
                for(int k=0; k<size; k++){
                    if(data[j][k]>i && !check[j][k]){
                        count+=dfs(j,k,i);
                        answer = Math.max(count,answer);
                    }
                }
            }
        }
        if(answer == 0 ) System.out.println(1);
        else System.out.println(answer);
    }

    private static int dfs(int x, int y, int limit) {
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        check[x][y] = true;
        for(int i=0; i<4; i++){
            int tmp_x = x+dx[i];
            int tmp_y = y+dy[i];
            if(tmp_x>=0 && tmp_y>=0 && tmp_x<size && tmp_y<size){
                if(!check[tmp_x][tmp_y] && data[tmp_x][tmp_y] > limit){
                    dfs(tmp_x,tmp_y,limit);
                }
            }
        }
        return 1;
    }
}