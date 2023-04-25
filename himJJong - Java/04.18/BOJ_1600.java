import java.io.*;
import java.util.*;

public class BOJ_1600 {
    static class Node{
        int x;
        int y;
        int horseCount;
        int time;
        Node(int x, int y, int horseCount, int time){
            this.x = x;
            this.y = y;
            this.horseCount = horseCount;
            this.time = time;
        }
    }
    static int[] NM;
    static int[][] data;
    static int horse;
    static int min = Integer.MAX_VALUE;
    static boolean[][][] visited;
    static List<Node> list = new ArrayList<>();

    static int[] horse_x = {1,2,-1,-2,1,2,-1,-2};
    static int[] horse_y = {2,1,2,1,-2,-1,-2,-1};
    static int[] monkey_x = {1,0,-1,0};
    static int[] monkey_y = {0,1,0,-1};
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        horse = Integer.parseInt(br.readLine());
        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        visited = new boolean[NM[1]][NM[0]][horse+1];
        data = new int[NM[1]][NM[0]];

        for(int i=0; i<NM[1]; i++){
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        list.add(new Node(0,0,horse,0));
        visited[0][0][horse] = true;

        if(NM[0] + NM[1] == 2) {
            System.out.println(0);
            System.exit(0);
        }
        bfs();

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void bfs() {
        while(!list.isEmpty()){
            Node tmp = list.remove(0);
            for(int i=0; i<4 ;i++){
                int move_x = monkey_x[i] + tmp.x;
                int move_y = monkey_y[i] + tmp.y;

                if(inArea(move_x,move_y) && !visited[move_x][move_y][tmp.horseCount] && data[move_x][move_y] != 1){
                    visited[move_x][move_y][tmp.horseCount] = true;
                    list.add(new Node(move_x,move_y,tmp.horseCount, tmp.time+1));
                }
                if(move_x == NM[1]-1 && move_y == NM[0]-1){
                    min = Math.min(min,tmp.time+1);
                }
            }

            if(tmp.horseCount > 0){             // 말이 되어 움직일 때
                for(int i=0; i<8; i++){
                    int move_x = horse_x[i] + tmp.x;
                    int move_y = horse_y[i] + tmp.y;

                    if(inArea(move_x,move_y) && !visited[move_x][move_y][tmp.horseCount-1] && data[move_x][move_y] != 1){
                        visited[move_x][move_y][tmp.horseCount-1] = true;
                        list.add(new Node(move_x,move_y,tmp.horseCount-1, tmp.time+1));
                    }
                    if(move_x == NM[1]-1 && move_y == NM[0]-1){
                        min = Math.min(min,tmp.time+1);
                    }
                }
            }
        }

    }

    private static boolean inArea(int move_x, int move_y) {
        if(move_x >=0 && move_x <NM[1] && move_y >=0 && move_y <NM[0]){
            return true;
        }
        return false;
    }
}
