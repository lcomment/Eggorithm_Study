import java.util.*;
import java.io.*;

public class BOJ_2606_BFS {
    static Queue<Integer> list = new LinkedList<>();
    static int[][] data;
    static int[] check;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int node = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());
        int answer = 0;

        data = new int[node+1][node+1];
        check = new int[node+1];

        for(int i=0; i<connect; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            data[x][y] = 1;
            data[y][x] = 1;
        }
        bfs(1);

        for(int i=0; i< check.length; i++){
            if(check[i]==1){
                answer++;
            }
        }
        System.out.println(answer-1);
    }

    private static void bfs(int start) {
        list.add(start);
        check[start] = 1;
        while(!list.isEmpty()){
            int val = list.poll();
            for(int i=0; i<check.length; i++){
                if(data[val][i] == 1 && check[i] != 1){
                    list.add(i);
                    check[i] = 1;
                }
            }
        }
    }
}
