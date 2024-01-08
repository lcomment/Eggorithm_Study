import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_17406 {
    static class Node{
        int r;
        int c;
        int s;
        Node(int r, int c, int s){
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
    static int N;
    static int M;
    static int spin;
    static int[][] map;
    static boolean[] visited;
    static List<Node> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    static List<Integer> order = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        spin = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[spin];

        for(int i=0; i<N; i++){
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for(int i=0; i<spin; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            list.add(new Node(r,c,s));
        }
        btk(0);
        System.out.println(min);
    }

    private static void btk(int index) {
        if(index == spin){
            for(int i=0; i<order.size(); i++){
                play(list.get(order.get(i)).r, list.get(order.get(i)).c, list.get(order.get(i)).s);
            }

            for(int i=0; i<N; i++){
                int sum = 0;
                for(int j=0; j<M; j++){
                    sum += map[i][j];
                }
                min = Math.min(min, sum);
            }
            return;
        }

        for(int i=0; i<spin; i++){
            if(!visited[i]){
                visited[i] = true;
                order.add(i);
                btk(index+1);
                order.remove(i);
                visited[i] = false;
            }
        }
    }

    private static void play(int r, int c, int s) {
        int startRow = r-s-1;
        int startCol = c-s-1;

        int endRow = r+s-1;
        int endCol = c+s-1;

        List<Integer> list = new ArrayList<>();
        handle(startRow, startCol, endRow, endCol, list,s);
    }

    private static void handle(int sr, int sc, int er, int ec, List<Integer> list, int s) {
        s--;
        for(int i=sc; i<=ec; i++){
            list.add(map[sr][i]);
        }

        for(int i=sr+1; i<=er; i++){
            list.add(map[i][ec]);
        }

        for(int i=ec-1; i>=sc; i--){
            list.add(map[er][i]);
        }

        for(int i=er-1; i>sr; i--){
            list.add(map[i][sc]);
        }

        int memory = list.get(list.size()-1);
        int index = 0;

        for(int i=sc+1; i<=ec; i++){
            map[sr][i] = list.get(index);
            index++;
        }

        for(int i=sr+1; i<=er; i++){
            map[i][ec] = list.get(index);
            index++;
        }

        for(int i=ec-1; i>=sc; i--){
            map[er][i] = list.get(index);
            index++;
        }

        for(int i=er-1; i>sr; i--){
            map[i][sc] = list.get(index);
            index++;
        }

        map[sr][sc] = memory;
        if(s!=0){
            list.clear();
            handle(sr+1,sc+1,er-1, ec-1,list, s);
        }
    }
}
