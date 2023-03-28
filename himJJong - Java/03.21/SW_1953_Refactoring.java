import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW_1953_Refactoring {
    static class Node{
        int x;
        int y;
        int time;
        Node(int x,int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int dr[] = {-1,0,1,0};
    static int dc[] = {0,-1,0,1};
    static int[] NM;
    static boolean[][] visited;
    static Queue<Node> q = new LinkedList<>();
    static String[] t = {"","0123","02","13","03","23","12","01"};
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        NM = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] data = new int[NM[0]][NM[1]];
        for (int i = 0; i < NM[0]; i++) {
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        visited = new boolean[NM[0]][NM[1]];
        Node val = new Node(NM[2], NM[3], 1);
        q.add(val);
        visited[NM[2]][NM[3]] = true;

        while(!q.isEmpty()){
            Node tmp = q.poll();
            if(tmp.time == NM[4]) break;
            int current = data[tmp.x][tmp.y];
            for(int d =0; d<4; d++){
                int moveX = tmp.x + dr[d];
                int moveY = tmp.y + dc[d];
                if(moveX < 0 || moveY <0 || moveX>=NM[0] || moveY >= NM[1] ||
                        visited[moveX][moveY] || data[moveX][moveY]==0) continue;

                int nextTunnel = data[moveX][moveY];
                String Dir = Integer.toString((d+2)%4);

                if(!t[nextTunnel].contains(Dir)) continue;      // 반대 출입구의 입구를 가지고 있지 않다면 continue
                // 각 0123 북서남동       아래와 같은 예시로 형식을 짠듯
                if(current == 2 && d%2 != 0) continue;
                if(current == 3 && d%2 == 0) continue;
                if(current == 4 && d%3 != 0) continue;
                if(current == 5 && d < 2) continue;         //  2,3 의 입구가 있으므로 1,2의 출구가 있으면 됨
                if(current == 6 && d%3 == 0) continue;      //  1,2 의 출구가 있으므로 0,3일 때 출구가 있으면됨
                if(current == 7 && d > 1) continue;

                visited[moveX][moveY] = true;
                q.add(new Node(moveX,moveY,tmp.time+1));
                answer++;
            }
        }
        System.out.println(answer);
    }
}
