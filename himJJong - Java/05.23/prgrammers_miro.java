import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prgrammers_miro {
    static class Node{
        int x;
        int y;
        int time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static String[] maps = {"SLEOX", "XXXXO", "OOOOO", "OXXXX", "OOOOO"};
    static String[][] data;
    static Node start;
    static Node Lever;
    static Node exit;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int answer = 0;
    static Queue<Node> q = new LinkedList<>();
    static int flag = 0;
    public static void main(String[] args){
        data = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for(int i=0; i<maps.length; i++){
            data[i] = maps[i].split("");

            for(int j=0; j<maps[0].length(); j++){
                if(data[i][j].equals("S")){
                    start = new Node(i,j,0);
                }
                if(data[i][j].equals("L")){
                    Lever = new Node(i,j,0);
                }
                if(data[i][j].equals("E")){
                    exit = new Node(i,j,0);
                }
            }
        }

        bfs(start,Lever);
        if(flag == 1){
            visitedInit();
        }
        else {
            System.out.println(-1);
            System.exit(0);
        }

        bfs(Lever,exit);
        if(flag == 2){
            System.out.println(answer);
        }
        else {
            System.out.println(-1);
            System.exit(0);
        }
    }
    private static void bfs(Node source, Node goal) {
        q.add(source);
        while (!q.isEmpty()){
            Node tmp = q.poll();
            for(int i=0; i<4; i++){
                int move_X = dx[i] + tmp.x;
                int move_Y = dy[i] + tmp.y;

                if(move_X == goal.x && move_Y == goal.y){
                    q.clear();
                    answer += tmp.time + 1;
                    flag += 1;
                    break;
                }
                if(inArea(move_X,move_Y) && !data[move_X][move_Y].equals("X") && !visited[move_X][move_Y]){
                    visited[move_X][move_Y] = true;
                    q.add(new Node(move_X, move_Y, tmp.time+1));
                }
            }
        }
    }

    private static boolean inArea(int moveX, int moveY) {
        return moveX >= 0 && moveX < data.length && moveY >= 0 && moveY < data[0].length;
    }

    private static void visitedInit() {
        for(int i=0; i<visited.length; i++){
            Arrays.fill(visited[i],false);
        }
    }
}



















