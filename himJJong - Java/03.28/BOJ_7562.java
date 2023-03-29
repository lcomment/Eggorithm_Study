import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class BOJ_7562 {
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
    static List<Node> list = new ArrayList<>();
    static int[] dx = {2,2,1,1,-2,-2,-1,-1};
    static int[] dy = {1,-1,2,-2,1,-1,2,-2};
    static int length = 0;
    static boolean[][] visited;
    static int answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        
        for(int i=0; i<testcase;i++){
            answer = 0;
            length = Integer.parseInt(br.readLine());
            visited = new boolean[length][length];
            st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());
            Node current = new Node(currentX,currentY,0);
            
            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());
            Node goal = new Node(goalX,goalY,0);
            if(currentX == goalX && currentY == goalY) answer = 0;
            else bfs(current,goal,0);
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(Node current, Node goal, int time) {

        list.add(current);
        while(!list.isEmpty()){
            Node val = list.remove(0);
            visited[val.x][val.y] = true;
            for(int i=0; i<8;i++){
                int moveX = val.x + dx[i];
                int moveY = val.y + dy[i];
                int time_val = val.time + 1;
                if(goal.x == moveX && moveY == goal.y) {
                    list.clear();
                    answer = time_val;
                    break;
                }
                if(moveX>=0 && moveX<length && moveY>=0 && moveY<length && !visited[moveX][moveY]){
                    visited[moveX][moveY] = true;
                    list.add(new Node(moveX,moveY, time_val));

                }
            }
        }
    }
}
