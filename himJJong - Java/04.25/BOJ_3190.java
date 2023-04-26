import java.io.*;
import java.util.*;

public class BOJ_3190 {
    static class location {
        int x;
        int y;
        location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Integer> timeList = new ArrayList<>();
    static List<Integer> x_List = new ArrayList<>();
    static List<Integer> y_List = new ArrayList<>();
    static List<String> spinList = new ArrayList<>();
    static int N;
    static int[][] map;
    static List<int[]> dq = new ArrayList<>();
    static Queue<location> snakeData = new LinkedList<>();
    static int[] east = {0,1};
    static int[] south = {1,0};
    static int[] west = {0,-1};
    static int[] north = {-1,0};
    static int time = 0;
    static int spinIndex = 0;
    static int timeIndex = 0;
    static int memory_x = 1;
    static int memory_y = 1;


    //  ToDo    -> map[x][y] == 6 사과
    //  ToDo    -> map[x][y] == 0 빈칸
    //  ToDo    -> map[x][y] == 1 뱀의 몸
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        int apple = Integer.parseInt(br.readLine());
        int[][] appleData = new int[apple][2];

        for(int i=0; i<appleData.length; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 6;
        }

        int spin = Integer.parseInt(br.readLine());

        dq.add(east);
        dq.add(south);
        dq.add(west);
        dq.add(north);

        for(int i=0; i<spin; i++){
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String spinloc = st.nextToken();

            timeList.add(time);
            spinList.add(spinloc);
        }
        x_List.add(1);
        y_List.add(1);
        snakeData.add(new location(1,1));
        System.out.println(playGame());
    }

    private static int playGame() {
        while (true) {
            int[] tmp = dq.get(spinIndex);
            int move_x = memory_x + tmp[0];
            int move_y = memory_y + tmp[1];
            if (move_x >= 1 && move_x <= N && move_y >= 1 && move_y <= N) {
                if(checkSnake(move_x,move_y)){
                    time++;
                    if(timeIndex != timeList.size() && timeList.get(timeIndex) == time){
                        if(spinList.get(timeIndex).equals("D")){
                            if(spinIndex !=3) spinIndex++;
                            else spinIndex = 0;
                        }
                        else if(spinList.get(timeIndex).equals("L")){
                            if(spinIndex == 0 ) spinIndex = 3;
                            else spinIndex--;
                        }
                        timeIndex++;
                    }

                    if (map[move_x][move_y] == 0) {
                        snakeData.add(new location(move_x,move_y));
                        snakeData.poll();
                        x_List.add(move_x);
                        y_List.add(move_y);
                        x_List.remove(0);
                        y_List.remove(0);

                    }
                    else if (map[move_x][move_y] == 6) {
                        snakeData.add(new location(move_x,move_y));
                        map[move_x][move_y] = 0;
                        x_List.add(move_x);
                        y_List.add(move_y);
                    }
                }
                else break;

                memory_x = move_x;
                memory_y = move_y;
            }
            else break;
        }
        return time+1;
    }

    private static boolean checkSnake(int move_x, int move_y) {
        for(int i=0; i<x_List.size(); i++){
            if(move_x == x_List.get(i) && move_y == y_List.get(i)) return false;
        }
        return true;
    }
}
